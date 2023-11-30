package project.daoimpl;

import project.dao.PartDao;
import project.dao.RollingStockDao;
import project.exceptions.CustomDuplicateKeyException;
import project.exceptions.UserDatabaseException;
import project.model.product.RollingStock;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.Era;
import project.model.product.enums.RollingStockType;
import project.service.MySqlService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RollingStockDaoImpl extends ProductDaoImpl implements RollingStockDao {
    private static final Logger LOGGER = Logger.getLogger(RollingStockDaoImpl.class.getName());

    @Override
    public void addRollingStock(RollingStock rollingStock) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // First, add the generic product attributes
            super.addProduct(rollingStock, connection);
            PartDao partDao = new PartDaoImpl();
            partDao.addPart(rollingStock, connection);

            // Then, add the specific attributes of the RollingStock
            String sqlRollingStock = "INSERT INTO rolling_stock (product_code, rolling_stock_type, era) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlRollingStock);

            preparedStatement.setString(1, rollingStock.getProductCode());
            preparedStatement.setString(2, rollingStock.getRollingStockType().name());
            preparedStatement.setString(3, rollingStock.getEra().name());

            preparedStatement.executeUpdate();

            connection.commit(); // Commit transaction
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            if (e.getSQLState().equals("23000")) {
                throw new CustomDuplicateKeyException("A rolling stock with the same product code already exists.");
            }
            LOGGER.log(Level.SEVERE, "Error adding rolling stock to the database", e);
            throw new RuntimeException("Error adding rolling stock", e);
        }
    }


    @Override
    public RollingStock getRollingStock(String productCode) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Product product = super.getProduct(productCode);
            if (product == null) {
                LOGGER.info("No product found with productCode: " + productCode);
                return null;
            }

            if (!(product instanceof RollingStock)) {
                throw new UserDatabaseException("Product with code " + productCode + " is not RollingStock.");
            }
            RollingStock rollingStock = (RollingStock) product;

            connection = MySqlService.getConnection();
            if (connection == null) {
                LOGGER.info("Database connection is null");
                return null;
            }

            String sqlRollingStock = "SELECT rolling_stock_type, era FROM rolling_stock WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlRollingStock);
            preparedStatement.setString(1, productCode);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                RollingStockType rollingStockType = RollingStockType.valueOf(resultSet.getString("rolling_stock_type"));
                Era era = Era.valueOf(resultSet.getString("era"));

                rollingStock.setRollingStockType(rollingStockType);
                rollingStock.setEra(era);
            }

            return rollingStock;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving rolling stock with productCode: " + productCode, e);
            throw new UserDatabaseException("Error retrieving rolling stock from database", e);
        }
    }

    @Override
    public List<RollingStock> getAllRollingStock() throws SQLException {
        List<RollingStock> rollingStocks = new ArrayList<>();
        String sql = "SELECT p.product_code, p.brand_name, p.product_name, p.retail_price, p.gauge_type, r.rolling_stock_type, r.era FROM product p JOIN rolling_stock r ON p.product_code = r.product_code";
        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                RollingStock rollingStock = RollingStock.fromResultSet(rs);
                rollingStocks.add(rollingStock);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all rolling stocks", e);
            throw new RuntimeException("Database operation failed", e);
        }
        return rollingStocks;
    }

    @Override
    public void updateRollingStock(RollingStock rollingStock) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Update common Product attributes
            super.updateProduct(rollingStock, connection);

            // Update specific RollingStock attributes
            String sqlRollingStock = "UPDATE rolling_stock SET rolling_stock_type = ?, era = ? WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlRollingStock);

            preparedStatement.setString(1, rollingStock.getRollingStockType().name());
            preparedStatement.setString(2, rollingStock.getEra().name());
            preparedStatement.setString(3, rollingStock.getProductCode());
            preparedStatement.executeUpdate();

            connection.commit(); // Commit transaction
            LOGGER.info("RollingStock updated successfully for productCode: " + rollingStock.getProductCode());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating RollingStock: " + e.getMessage(), e);
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
    public void deleteRollingStock(String productCode) throws SQLException {
        Connection connection = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Delete from rolling_stock table
            String sqlRollingStock = "DELETE FROM rolling_stock WHERE product_code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRollingStock)) {
                preparedStatement.setString(1, productCode);
                preparedStatement.executeUpdate();
            }

            // Delete from part table if necessary
            PartDao partDao = new PartDaoImpl();
            partDao.deletePart(productCode, connection);

            // Delete from product table
            String sqlProduct = "DELETE FROM product WHERE product_code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlProduct)) {
                preparedStatement.setString(1, productCode);
                preparedStatement.executeUpdate();
            }

            connection.commit(); // Commit transaction
            LOGGER.info("RollingStock deleted successfully for productCode: " + productCode);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting RollingStock with productCode: " + productCode, e);
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction in case of error
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            throw new RuntimeException("Database operation failed for productCode: " + productCode, e);
        }
    }
}
