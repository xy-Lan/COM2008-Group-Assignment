package project.daoimpl;

import project.dao.ControllerDao;
import project.dao.PartDao;
import project.dao.ProductDao;
import project.model.product.Controller;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.ControllerType;
import project.service.MySqlService;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerDaoImpl extends ProductDaoImpl implements ControllerDao {
    private static final Logger LOGGER = Logger.getLogger(ControllerDaoImpl.class.getName());

    @Override
    public void addController(Controller controller) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // // Start transaction

            // First, call the superclass method to handle the common Product attributes
            LOGGER.info("Attempting to add product");
            super.addProduct(controller, connection);
            LOGGER.info("Product added successfully");
            PartDao partDao = new PartDaoImpl();
            LOGGER.info("Attempting to add part");
            partDao.addPart(controller, connection);
            LOGGER.info("Part added successfully");
            System.out.println("Add partdao successfully");

            // Then, add the specific attributes of the Controller
            String sqlController = "INSERT INTO controller (product_code, controller_type, is_digital) VALUES (?, ?, ?)";
            LOGGER.info("preparation to add controller");
            preparedStatement = connection.prepareStatement(sqlController);
            System.out.println("try");
            try {
                LOGGER.info("Attempting to add controller");
                preparedStatement.setString(1, controller.getProductCode());
                preparedStatement.setString(2, controller.getControllerType().name());
                preparedStatement.setBoolean(3, controller.getIsDigital());
                preparedStatement.executeUpdate();
                LOGGER.info("Controller added successfully");
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error adding controller to the database "+ e.getMessage(), e);
                throw e;
            }

            LOGGER.info("Attempting to commit transaction");
            connection.commit(); // Commit transaction
            LOGGER.info("Transaction committed successfully");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in transaction"+ e.getMessage(), e);
            if (connection != null) {
                try {
                    if (!connection.isClosed()) {
                        connection.rollback();
                    }
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            LOGGER.log(Level.SEVERE, "Error in operation: " + e.getMessage(), e);
            e.printStackTrace();
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public Controller getController(String productCode) {
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
            System.out.println(product.getProductCode());
            if (!(product instanceof Controller)) {
                throw new RuntimeException("Product with code " + productCode + " is not a Controller.");
            }
            Controller controller = (Controller) product;

            connection = MySqlService.getConnection();
            if (connection == null) {
                System.out.println("the connection is null");
            }

            // Then get the unique properties from the controller table
            String sqlController = "SELECT controller_type, is_digital FROM controller WHERE product_code = ?";
            try {
                preparedStatement = connection.prepareStatement(sqlController);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preparedStatement.setString(1, productCode);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ControllerType controllerType = ControllerType.valueOf(resultSet.getString("controller_type"));
                boolean isDigital = resultSet.getBoolean("is_digital");

                controller.setControllerType(controllerType);
                controller.setIsDigital(isDigital);
            }

            return controller;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving controller with productCode: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            // Close resources
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignored */ }
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }

    @Override
    public List<Controller> getAllControllers() {
        List<Controller> controllers = new ArrayList<>();
        // The SQL query should fetch all relevant properties of the Controller.
        String sql = "SELECT p.product_code, p.brand_name, p.product_name, p.retail_price, p.gauge_type, c.controller_type," +
                " c.is_digital FROM product p JOIN controller c ON p.product_code = c.product_code";
        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Using the Methods for Creating a Controller from a ResultSet
                Controller controller = Controller.fromResultSet(rs);
                controllers.add(controller);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all controllers", e);
            throw new RuntimeException("Database operation failed", e);
        }
        return controllers;
    }

    @Override
    public void updateController(Controller controller) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
             // Start transaction
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false);
            // Update common Product attributes
            super.updateProduct(controller, connection);

            // Update specific Controller attributes
            String sqlController = "UPDATE controller SET controller_type = ?, is_digital = ? WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlController);

            preparedStatement.setString(1, controller.getControllerType().name());
            preparedStatement.setBoolean(2, controller.getIsDigital());
            preparedStatement.setString(3, controller.getProductCode());
            preparedStatement.executeUpdate();

            connection.commit(); // Commit transaction
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction in case of error
                } catch (SQLException ex) {
                    // Log error during rollback
                }
            }
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public void deleteController(String productCode) {
        Connection connection = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Delete from controller table
            String sqlController = "DELETE FROM controller WHERE product_code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlController)) {
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
            LOGGER.info("Controller deleted successfully");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting controller: " + e.getMessage(), e);
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
