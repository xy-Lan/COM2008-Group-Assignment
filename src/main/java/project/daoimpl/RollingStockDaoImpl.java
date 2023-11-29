package project.daoimpl;

import project.dao.PartDao;
import project.dao.RollingStockDao;
import project.model.product.RollingStock;
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
            super.addProduct(rollingStock);
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
            LOGGER.log(Level.SEVERE, "Error adding rolling stock to the database", e);
            throw e;
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.setAutoCommit(true); connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }


    @Override
    public RollingStock getRollingStock(String productNumber) throws SQLException {
        return null;
    }

    @Override
    public List<RollingStock> getAllRollingStock() throws SQLException {
        return null;
    }

    @Override
    public void updateRollingStock(RollingStock rollingStock) throws SQLException {

    }

    @Override
    public void deleteRollingStockById(int id) throws SQLException {

    }
}
