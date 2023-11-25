package project.daoimpl;

import project.dao.ControllerDao;
import project.dao.ProductDao;
import project.model.product.Controller;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.ControllerType;
import project.service.MysqlService;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerDaoImpl extends ProductDaoImpl implements ControllerDao {
    private static final Logger LOGGER = Logger.getLogger(ControllerDaoImpl.class.getName());

    private MysqlService mysqlService;

    public ControllerDaoImpl(MysqlService mysqlService) {
        super(mysqlService);
    }

    @Override
    public void addController(Controller controller) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = mysqlService.getConnection();
            connection.setAutoCommit(false); // // Start transaction

            // First, call the superclass method to handle the common Product attributes
            super.addProduct(controller);

            // Then, add the specific attributes of the Controller
            String sqlController = "INSERT INTO controller (product_code, controller_type, is_digital) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlController);

            // Set the parameters for the preparedStatement
            preparedStatement.setString(1, controller.getProductCode());
            preparedStatement.setString(2, controller.getControllerType().name());
            preparedStatement.setBoolean(3, controller.getIsDigital());

            preparedStatement.executeUpdate();

            connection.commit(); // Commit transaction
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();  // Rollback transaction
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            LOGGER.log(Level.SEVERE, "Error adding controller to the database", e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.setAutoCommit(true); connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }

    @Override
    public Controller getController(String productCode) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = mysqlService.getConnection();

            // First get the generic attributes from the product table
            Product product = super.getProduct(productCode);
            if (!(product instanceof Controller)) {
                throw new RuntimeException("Product with code " + productCode + " is not a Controller.");
            }
            Controller controller = (Controller) product;

            // Then get the unique properties from the controller table
            String sqlController = "SELECT controller_type, is_digital FROM controller WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlController);
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
        String sql = "SELECT p.product_code, p.brand_name, p.product_name, p.retail_price, p.gauge_type, c.controller_type, c.is_digital FROM product p JOIN controller c ON p.product_code = c.product_code";
        try (Connection conn = mysqlService.getConnection();
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
        // Implement logic to update a controller's information in the database
    }

    @Override
    public void deleteController(String id) {
        // Implement logic to delete a controller from the database
    }

    // Other necessary methods...
}
