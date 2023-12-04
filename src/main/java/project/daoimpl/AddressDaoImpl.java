package project.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import project.dao.AddressDao;
import project.model.address.Address;
import project.service.MySqlService;

public class AddressDaoImpl implements AddressDao{

    private static final Logger LOGGER = Logger.getLogger(AddressDaoImpl.class.getName());

    @Override
    public Boolean isAddressExist(String houseNumber, String postCode) {
        String sql = "SELECT COUNT(*) FROM address WHERE house_number = ? AND post_code = ?";
        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, houseNumber);
            stmt.setString(2, postCode);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error checking if address exists", e);
        }
        return false;
    }



    @Override
    public Integer getAddressId(String houseNumber, String postCode) {
        String sql = "SELECT address_id FROM address WHERE house_number = ? AND post_code = ?";
        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, houseNumber);
            stmt.setString(2, postCode);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("address_id");
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving address ID", e);
        }
        return null;
    }

    @Override
    public Integer addAddressIfNotExist(Address address) {
        Integer addressId = null;
        if (!isAddressExist(address.getHouseNumber(), address.getPostCode())) {
            addressId = addAddressReturnId(address);
        } else {
            addressId = getAddressId(address.getHouseNumber(), address.getPostCode());
            LOGGER.info("Address already exists: " + address.getHouseNumber() + ", " + address.getPostCode());
        }
        return addressId;
    }

    @Override
    public int addAddressReturnId(Address address) {
        String sql = "INSERT INTO address (house_number, post_code, road_name, city_name) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        int addressId = -1;

        try {
            conn = MySqlService.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            address.setPreparedStatement(stmt);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating address failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    addressId = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating address failed, no ID obtained.");
                }
            }

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            LOGGER.log(Level.SEVERE, "Error adding address to the database", e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (stmt != null) try { stmt.close(); } catch (SQLException e) {  }
            if (conn != null) try { conn.close(); } catch (SQLException e) { }
        }

        return addressId;
    }


    @Override
    public void addAddress(Address address) {
        String sql = "INSERT INTO address (house_number, post_code, road_name, city_name) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = MySqlService.getConnection();
            conn.setAutoCommit(false); // Disable auto-commit

            stmt = conn.prepareStatement(sql);
            address.setPreparedStatement(stmt);
            stmt.executeUpdate();

            conn.commit(); // Commit transaction
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback transaction on error
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            LOGGER.log(Level.SEVERE, "Error adding address to the database", e);
            throw new RuntimeException("Database operation failed", e);
        }
    }


    @Override
    public Address getAddress(int addressId) {
        Address address = null;
        String sql = "SELECT * FROM address WHERE address_id = ?";
    
        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, addressId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs);
                    address = Address.fromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving address from the database", e);
            throw new RuntimeException("Database operation failed", e);
        }
        return address;
    }
    


    @Override
    public List<Address> getAllAddresses() {
        List<Address> addresses = new ArrayList<>();
        String sql = "SELECT * FROM address";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Address address = Address.fromResultSet(rs);
                addresses.add(address);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all addresses", e);
            throw new RuntimeException("Database operation failed", e);
        }
        return addresses;
    }


    @Override
    public void updateAddress(Address address) {
        String sql = "UPDATE address SET road_name = ?, city_name = ? WHERE house_number = ? AND post_code = ?";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, address.getRoadName());
            stmt.setString(2, address.getCityName());
            stmt.setString(3, address.getHouseNumber());
            stmt.setString(4, address.getPostCode());

            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected);
            if (rowsAffected == 0) {

                throw new SQLException("Updating address failed, no rows affected.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating address in the database", e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public void deleteAddress(String houseNumber, String postCode) {
    }

}
