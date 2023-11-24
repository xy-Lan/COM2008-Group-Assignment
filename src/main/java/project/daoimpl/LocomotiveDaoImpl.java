package project.daoimpl;

import project.dao.LocomotiveDao;
import project.model.product.Locomotive;
import project.dao.ProductDao;
import project.service.MysqlService;

import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocomotiveDaoImpl extends ProductDaoImpl implements LocomotiveDao  {
    private static final Logger LOGGER = Logger.getLogger(LocomotiveDaoImpl.class.getName());
    private MysqlService mysqlService;

    public LocomotiveDaoImpl(MysqlService mysqlService) {
        super(mysqlService);
    }

    @Override
    public void addLocomotive(Locomotive locomotive) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = mysqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // First, call the superclass method to handle the common Product attributes
            super.addProduct(locomotive);

            // Then, add the specific attributes of the Locomotive
            String sqlLocomotive = "INSERT INTO locomotive (product_code, dcc_type, era) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlLocomotive);

            // 设置 preparedStatement 的参数
            // Set the parameters for the preparedStatement
            preparedStatement.setString(1, locomotive.getProductCode());
            preparedStatement.setString(2, locomotive.getDccType().name());
            preparedStatement.setString(3, locomotive.getEra().name());

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
            LOGGER.log(Level.SEVERE, "Error adding locomotive to the database", e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }


    @Override
    public Locomotive getLocomotive(String id) {
        // Implement logic to retrieve a locomotive from the database

        return null;
    }

    @Override
    public List<Locomotive> getAllLocomotives() {
        // Implement logic to retrieve all locomotives from the database
        return null;
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
