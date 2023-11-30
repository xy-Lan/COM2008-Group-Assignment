package project.daoimpl;

import project.dao.BoxedSetDao;
import project.dao.ProductDao;
import project.dao.TrainSetDao;
import project.exceptions.UserDatabaseException;
import project.model.product.TrainSet;
import project.model.product.abstractproduct.Product;
import project.service.MySqlService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import java.sql.*;

public class TrainSetDaoImpl extends  ProductDaoImpl implements TrainSetDao {

    private static final Logger LOGGER = Logger.getLogger(TrainSetDaoImpl.class.getName());

    @Override
    public void addTrainSet(TrainSet trainSet) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // First, add the generic product attributes
            super.addProduct(trainSet, connection);
            BoxedSetDao boxedSetDao = new BoxedSetDaoImpl();
            boxedSetDao.addBoxedSet(trainSet, connection);

            String sqlTrainSet = "INSERT INTO train_set (product_code) VALUES (?)";
            preparedStatement = connection.prepareStatement(sqlTrainSet);
            preparedStatement.setString(1, trainSet.getProductCode());

            preparedStatement.executeUpdate();

            // If TrainSet has more specific attributes, add them here

            connection.commit(); // Commit transaction
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            LOGGER.log(Level.SEVERE, "Error adding train set to the database", e);
            throw new RuntimeException("Error adding train set", e);
        }
    }


    @Override
    public TrainSet getTrainSet(String productCode) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Product product = super.getProduct(productCode);
            if (product == null) {
                LOGGER.info("No product found with productCode: " + productCode);
                return null;
            }

            if (!(product instanceof TrainSet)) {
                throw new UserDatabaseException("Product with code " + productCode + " is not a TrainSet.");
            }
            TrainSet trainSet = (TrainSet) product;

            connection = MySqlService.getConnection();
            if (connection == null) {
                LOGGER.info("Database connection is null");
                return null;
            }

            String sqlTrainSet = "SELECT * FROM train_set WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlTrainSet);
            preparedStatement.setString(1, productCode);
            resultSet = preparedStatement.executeQuery();


            return trainSet;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving train set with productCode: " + productCode, e);
            throw new UserDatabaseException("Error retrieving train set from database", e);
        }
    }


    @Override
    public List<TrainSet> getAllTrainSets() {
        List<TrainSet> trainSets = new ArrayList<>();
        String sql = "SELECT ts.product_code, p.product_name, p.brand_name, p.retail_price, p.gauge_type " +
                "FROM train_set ts JOIN product p ON ts.product_code = p.product_code";
        try (Connection conn = MySqlService.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TrainSet trainSet = TrainSet.fromResultSet(rs);
                trainSets.add(trainSet);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in getting all train sets", e); 
            throw new RuntimeException("Database operation failed", e)
;        }
        return trainSets;
    }

    @Override
    public void updateTrainSet(TrainSet trainSet)  {
        Connection connection = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Update common Product attributes
            super.updateProduct(trainSet, connection);


            connection.commit(); // Commit transaction
            LOGGER.info("TrainSet updated successfully for productCode: " + trainSet.getProductCode());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating TrainSet: " + e.getMessage(), e);
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction in case of error
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            throw new RuntimeException("Database operation failed ", e);
        }
    }


    @Override
    public void deleteTrainSet(String productCode) {
        Connection connection = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            String sqlTrainSet = "DELETE FROM train_set WHERE product_code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlTrainSet)) {
                preparedStatement.setString(1, productCode);
                preparedStatement.executeUpdate();
            }

            BoxedSetDao boxedSetDao = new BoxedSetDaoImpl();
            boxedSetDao.deleteBoxedSet(productCode, connection);

            String sqlProduct = "DELETE FROM product WHERE product_code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlProduct)) {
                preparedStatement.setString(1, productCode);
                preparedStatement.executeUpdate();
            }

            connection.commit();
            LOGGER.info("TrainSet deleted successfully for productCode: " + productCode);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting TrainSet with productCode: " + productCode, e);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            throw new RuntimeException("Database operation failed for productCode: " + productCode, e);
        }
    }

}
