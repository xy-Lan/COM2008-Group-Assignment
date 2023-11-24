package project.daoimpl;

import project.dao.CarriageDao;
import project.dao.ProductDao;
import project.model.product.Carriage;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.CarriageType;
import project.model.product.enums.Era;
import project.service.MysqlService;

import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarriageDaoImpl extends  ProductDaoImpl implements CarriageDao {
    private static final Logger LOGGER = Logger.getLogger(CarriageDaoImpl.class.getName());
    private MysqlService mysqlService;

    public CarriageDaoImpl(MysqlService mysqlService) {
        super(mysqlService);
    }

    @Override
    public void addCarriage(Carriage carriage) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = mysqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // First, the super class method is called to handle the generic Product property
            super.addProduct(carriage);

            // Then, add Carriage-specific properties
            String sqlCarriage = "INSERT INTO carriage (product_code, carriage_type, era) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlCarriage);

            // Setting the parameters of a preparedStatement
            preparedStatement.setString(1, carriage.getProductCode());
            preparedStatement.setString(2, carriage.getCarriageType().name());
            preparedStatement.setString(3, carriage.getEra().name());

            preparedStatement.executeUpdate();

            connection.commit(); // submit transaction
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // transaction bollback
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            LOGGER.log(Level.SEVERE, "Error adding carriage to the database", e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }

    @Override
    public Carriage getCarriage(String productCode) {
        Carriage carriage = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = mysqlService.getConnection();

            // Get generic Product property
            Product product = super.getProduct(productCode);
            if (!(product instanceof Carriage)) {
                throw new RuntimeException("Product with code " + productCode + " is not a Carriage.");
            }
            carriage = (Carriage) product;

            // Get Carriage-specific properties
            String sqlCarriage = "SELECT carriage_type, era FROM carriage WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlCarriage);
            preparedStatement.setString(1, productCode);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                CarriageType carriageType = CarriageType.valueOf(resultSet.getString("carriage_type"));
                Era era = Era.valueOf(resultSet.getString("era"));

                carriage.setCarriageType(carriageType);
                carriage.setEra(era);
            }

            return carriage;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving carriage with productCode: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignored */ }
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }

    @Override
    public List<Carriage> getAllCarriages() {
        // Implement logic to retrieve all carriages from the database
        return null;
    }

    @Override
    public void updateCarriage(Carriage carriage) {
        // Implement logic to update a carriage's information in the database
    }

    @Override
    public void deleteCarriage(String id) {
        // Implement logic to delete a carriage from the database
    }

    // Other necessary methods...
}
