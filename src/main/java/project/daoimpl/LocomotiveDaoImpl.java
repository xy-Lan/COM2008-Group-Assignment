package project.daoimpl;

import project.dao.LocomotiveDao;
import project.dao.PartDao;
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
            throw new RuntimeException("Database operation failed", e);
        }
    }


    @Override
    public Locomotive getLocomotive(String productCode) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySqlService.getConnection();

            // Retrieve common Product attributes
            Product product = super.getProduct(productCode);
            if (!(product instanceof Locomotive)) {
                throw new RuntimeException("Product with code " + productCode + " is not a Locomotive.");
            }
            Locomotive locomotive = (Locomotive) product;

            // Retrieve specific attributes of the Locomotive
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
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignored */ }
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
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
        // Implement logic to update a locomotive's information in the database
    }

    @Override
    public void deleteLocomotive(String id) {
        // Implement logic to delete a locomotive from the database
    }

    // Other necessary methods...

}
