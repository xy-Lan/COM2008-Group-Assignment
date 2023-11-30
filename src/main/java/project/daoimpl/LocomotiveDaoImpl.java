package project.daoimpl;

import project.dao.LocomotiveDao;
import project.dao.PartDao;
import project.exceptions.CustomDuplicateKeyException;
import project.model.product.Locomotive;
import project.dao.ProductDao;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.DCCType;
import project.model.product.enums.Era;
import project.service.MySqlService;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocomotiveDaoImpl extends ProductDaoImpl implements LocomotiveDao  {
    private static final Logger LOGGER = Logger.getLogger(LocomotiveDaoImpl.class.getName());

    @Override
    public void addLocomotive(Locomotive locomotive) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // First, call the superclass method to handle the common Product attributes
            LOGGER.info("Attempting to add product");
            super.addProduct(locomotive, connection);
            LOGGER.info("Product added successfully");

            // Assuming you have additional parts related to the locomotive
            PartDao partDao = new PartDaoImpl();
            LOGGER.info("Attempting to add part");
            partDao.addPart(locomotive, connection);
            LOGGER.info("Part added successfully");

            // Then, add the specific attributes of the Locomotive
            String sqlLocomotive = "INSERT INTO locomotive (product_code, dcc_type, era) VALUES (?, ?, ?)";
            LOGGER.info("Preparing to add locomotive");
            preparedStatement = connection.prepareStatement(sqlLocomotive);

            locomotive.setSubclassTableParameters(preparedStatement);
            preparedStatement.executeUpdate();
            LOGGER.info("Locomotive added successfully");

            LOGGER.info("Attempting to commit transaction");
            connection.commit(); // Commit transaction
            LOGGER.info("Transaction committed successfully");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in transaction: " + e.getMessage(), e);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            if (e.getSQLState().equals("23000")) {
                throw new CustomDuplicateKeyException("A rolling stock with the same product code already exists.");
            }

            throw new RuntimeException("Database operation failed", e);
        }
    }


    @Override
    public Locomotive getLocomotive(String productCode) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // First get the generic attributes from the product table
            Product product = super.getProduct(productCode);
            if (product == null) {
                LOGGER.info("No product found with productCode: " + productCode);
                return null;
            }

            if (!(product instanceof Locomotive)) {
                throw new RuntimeException("Product with code " + productCode + " is not a Locomotive.");
            }
            Locomotive locomotive = (Locomotive) product;

            connection = MySqlService.getConnection();
            if (connection == null) {
                LOGGER.info("Database connection is null");
                return null;
            }

            // Then get the unique properties from the locomotive table
            String sqlLocomotive = "SELECT dcc_type, era FROM locomotive WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlLocomotive);
            preparedStatement.setString(1, productCode);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                DCCType dccType = DCCType.valueOf(resultSet.getString("dcc_type"));
                Era era = Era.valueOf(resultSet.getString("era"));

                locomotive.setDccType(dccType);
                locomotive.setEra(era);
            }

            return locomotive;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving locomotive with productCode: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        }
    }


    @Override
    public List<Locomotive> getAllLocomotives() {
        List<Locomotive> locomotives = new ArrayList<>();
        String sql = "SELECT p.product_code, p.brand_name, p.product_name, p.retail_price, p.gauge_type, l.dcc_type, l.era FROM product p JOIN locomotive l ON p.product_code = l.product_code";
        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Using the Create Locomotive from ResultSet method
                Locomotive locomotive = Locomotive.fromResultSet(rs);
                locomotives.add(locomotive);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all locomotives", e);
            throw new RuntimeException("Database operation failed", e);
        }
        return locomotives;
    }


    @Override
    public void updateLocomotive(Locomotive locomotive) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Update common Product attributes
            super.updateProduct(locomotive, connection);

            // Update specific Locomotive attributes
            String sqlLocomotive = "UPDATE locomotive SET dcc_type = ?, era = ? WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlLocomotive);

            preparedStatement.setString(1, locomotive.getDccType().name());
            preparedStatement.setString(2, locomotive.getEra().name());
            preparedStatement.setString(3, locomotive.getProductCode());
            preparedStatement.executeUpdate();

            connection.commit(); // Commit transaction
            LOGGER.info("Locomotive updated successfully for productCode: " + locomotive.getProductCode());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating locomotive: " + e.getMessage(), e);
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction in case of error
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public void deleteLocomotive(String productCode) {
        Connection connection = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Delete from locomotive table
            String sqlLocomotive = "DELETE FROM locomotive WHERE product_code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlLocomotive)) {
                preparedStatement.setString(1, productCode);
                preparedStatement.executeUpdate();
            }

            // Delete from part table if necessary
            // Assuming you have a method to delete part
            PartDao partDao = new PartDaoImpl();
            partDao.deletePart(productCode, connection);

            // Delete from product table
            String sqlProduct = "DELETE FROM product WHERE product_code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlProduct)) {
                preparedStatement.setString(1, productCode);
                preparedStatement.executeUpdate();
            }

            connection.commit(); // Commit transaction
            LOGGER.info("Locomotive deleted successfully for productCode: " + productCode);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting locomotive: " + e.getMessage(), e);
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction in case of error
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            throw new RuntimeException("Database operation failed", e);
        }
    }

    // Other necessary methods...

}
