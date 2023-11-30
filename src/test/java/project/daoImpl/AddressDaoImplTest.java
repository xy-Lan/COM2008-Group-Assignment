package project.daoImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import project.dao.AddressDao;
import project.daoimpl.AddressDaoImpl;
import project.model.address.Address;
import project.service.MySqlService;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressDaoImplTest {

    private AddressDao addressDao;

    @BeforeEach
    public void setUp() throws SQLException {
        addressDao = new AddressDaoImpl();
    }

    @Test
    public void testAddAddress() throws SQLException {
        Address address = new Address();
        address.setHouseNumber("123");
        address.setPostCode("12345");
        address.setRoadName("Test Road");
        address.setCityName("Test City");

        addressDao.addAddress(address);

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM address WHERE house_number = ? AND post_code = ?")) {
            stmt.setString(1, address.getHouseNumber());
            stmt.setString(2, address.getPostCode());

            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next());
            assertEquals("Test Road", rs.getString("road_name"));
            assertEquals("Test City", rs.getString("city_name"));
        }
    }

    @Test
    public void testIsAddressExist_WhenAddressDoesNotExist() {
        String houseNumber = "123";
        String postCode = "ABC123";
        assertFalse(addressDao.isAddressExist(houseNumber, postCode), "Should return false for non-existing address");
    }

    @Test
    public void testIsAddressExist_WhenAddressExists() {
        String houseNumber = "protobello";
        String postCode = "S1 4AT";

        assertTrue(addressDao.isAddressExist(houseNumber, postCode), "Should return true for existing address");
    }

    @Test
    public void testGetAddressById() throws SQLException {
        int addressId = insertTestAddress();

        Address address = addressDao.getAddress(addressId);

        assertNotNull(address);
        assertEquals("100", address.getHouseNumber());
        assertEquals("12345", address.getPostCode());
        assertEquals("Test Road", address.getRoadName());
        assertEquals("Test City", address.getCityName());
    }

    private int insertTestAddress() throws SQLException {
        String insertSql = "INSERT INTO address (house_number, post_code, road_name, city_name) VALUES ('100', '12345', 'Test Road', 'Test City')";
        int addressId = 0;

        try (Connection conn = MySqlService.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(insertSql, Statement.RETURN_GENERATED_KEYS);

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    addressId = generatedKeys.getInt(1);
                }
            }
        }
        return addressId;
    }

    @Test
    public void testGetAllAddresses() throws SQLException {
        try (Connection conn = MySqlService.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("INSERT INTO address (house_number, post_code, road_name, city_name) VALUES ('101', '12345', 'Test Road 1', 'Test City')");
            stmt.execute("INSERT INTO address (house_number, post_code, road_name, city_name) VALUES ('102', '54321', 'Test Road 2', 'Test City')");
        }

        List<Address> addresses = addressDao.getAllAddresses();

        assertNotNull(addresses);
        assertTrue(addresses.size() >= 2);


        try (Connection conn = MySqlService.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM address WHERE house_number IN ('101', '102')");
        }
    }


    @AfterEach
    public void tearDown() throws SQLException {
        try (Connection conn = MySqlService.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM address WHERE house_number = '123' AND post_code = '12345'");
            stmt.execute("DELETE FROM address WHERE house_number = '100' AND post_code = '12345'");
        }
    }


}

