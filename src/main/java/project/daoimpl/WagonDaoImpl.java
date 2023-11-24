package project.daoimpl;

import project.dao.ProductDao;
import project.dao.WagonDao;
import project.model.product.Wagon;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.Era;
import project.model.product.enums.WagonType;
import project.service.MysqlService;

import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WagonDaoImpl extends  ProductDaoImpl implements WagonDao {
    private static final Logger LOGGER = Logger.getLogger(WagonDaoImpl.class.getName());
    private MysqlService mysqlService;

    public WagonDaoImpl(MysqlService mysqlService) {
        super(mysqlService);
    }

    @Override
    public void addWagon(Wagon wagon) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = mysqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // First, call the superclass method to handle the common Product attributes
            super.addProduct(wagon);

            // Then, add the specific attributes of the Wagon
            String sqlWagon = "INSERT INTO wagon (product_code, wagon_type, era) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlWagon);

            // Set the parameters for the preparedStatement
            preparedStatement.setString(1, wagon.getProductCode());
            preparedStatement.setString(2, wagon.getWagonType().name());
            preparedStatement.setString(3, wagon.getEra().name());

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
            LOGGER.log(Level.SEVERE, "Error adding wagon to the database", e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }


    @Override
    public Wagon getWagon(String productCode) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = mysqlService.getConnection();

            // Retrieve common Product attributes
            Product product = super.getProduct(productCode);
            if (!(product instanceof Wagon)) {
                throw new RuntimeException("Product with code " + productCode + " is not a Wagon.");
            }
            Wagon wagon = (Wagon) product;

            // Retrieve specific attributes of the Wagon
            String sqlWagon = "SELECT wagon_type, era FROM wagon WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlWagon);
            preparedStatement.setString(1, productCode);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                WagonType wagonType = WagonType.valueOf(resultSet.getString("wagon_type"));
                Era era = Era.valueOf(resultSet.getString("era"));

                wagon.setWagonType(wagonType);
                wagon.setEra(era);
            }

            return wagon;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving wagon with productCode: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignored */ }
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }


    @Override
    public List<Wagon> getAllWagons() {
        // Implement logic to retrieve all wagons from the database
        return null;
    }

    @Override
    public void updateWagon(Wagon wagon) {
        // Implement logic to update a wagon's information in the database
    }

    @Override
    public void deleteWagon(String id) {
        // Implement logic to delete a wagon from the database
    }

    // Other necessary methods...
}
