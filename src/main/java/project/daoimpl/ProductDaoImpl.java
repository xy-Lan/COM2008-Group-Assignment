package project.daoimpl;

import project.dao.*;
import project.model.product.*;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.Gauge;
import project.service.MySqlService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDaoImpl implements ProductDao {
    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class.getName());

    @Override
    public void addProduct(Product product, Connection connection) {

        PreparedStatement preparedStatement = null;

        try {

            // Insert common attributes into the product table
            String sqlProduct = "INSERT INTO product (product_code, brand_name, product_name, retail_price, gauge_type) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlProduct);

            // Set parameters for the product table
            product.setProductTableParameters(preparedStatement);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding product to the database", e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // Log the exception but do not rethrow it, as it is non-critical
                    LOGGER.log(Level.WARNING, "Failed to close PreparedStatement", e);
                }
            }
        }
    }



    @Override
    public Product getProduct(String productCode) {
        String query = "SELECT * FROM product WHERE product_code = ?";
        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, productCode);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String brandName = resultSet.getString("brand_name");
                String productName = resultSet.getString("product_name");
                BigDecimal retailPrice = resultSet.getBigDecimal("retail_price");
                Gauge gaugeType = Gauge.valueOf(resultSet.getString("gauge_type"));

                char firstChar = productCode.charAt(0);
                System.out.println("it is "+firstChar);
                switch (firstChar) {
                    case 'R':
                        TrackDao trackDao = new TrackDaoImpl();
                        System.out.println("it is a track");
                        return new Track(productCode, brandName, productName, retailPrice, gaugeType, null);
                    case 'C':
                        ControllerDao controllerDao = new ControllerDaoImpl();
                        System.out.println("it is a controller");
                        return new Controller(productCode, brandName, productName, retailPrice, gaugeType, null, false);

                    case 'L':
                        LocomotiveDao locomotiveDao = new LocomotiveDaoImpl();
                        System.out.println("it is a locomotive");
                        return new Locomotive(productCode, brandName, productName, retailPrice, gaugeType, null, null);
                    case 'S':
                        RollingStockDao rollingStockDao = new RollingStockDaoImpl();
                        return new RollingStock(productCode, brandName, productName, retailPrice, gaugeType, null, null);
                    case 'M':
                        TrainSetDao trainSetDao = new TrainSetDaoImpl();
                        System.out.println("it is a TrainSet");
                        return new TrainSet(productCode, brandName, productName, retailPrice, gaugeType);
                    case 'P':
                        TrackPackDao trackPackDao = new TrackPackDaoImpl();
                        System.out.println("it is a TrackPack");
                        return new TrackPack(productCode, brandName, productName, retailPrice, gaugeType,null);
                    default:
                        throw new IllegalArgumentException("Unknown product type: " + firstChar);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving product with productCode: " + productCode, e);

            throw new RuntimeException("Database operation failed", e);
        }

        return null;
    }


    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try {
            Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String productCode = rs.getString("product_code");
                char firstChar = productCode.charAt(0);
                Product product;

                switch (firstChar) {
                    case 'R':
                        product = new TrackDaoImpl().getTrack(productCode);
                        break;
                    case 'C':
                        product = new ControllerDaoImpl().getController(productCode);
                        break;
                    case 'L':
                        product = new LocomotiveDaoImpl().getLocomotive(productCode);
                        break;
                    case 'S':
                        product = new RollingStockDaoImpl().getRollingStock(productCode);
                        break;
                    case 'M':
                        product = new TrainSetDaoImpl().getTrainSet(productCode);
                        break;
                    case 'P':
                        product = new TrackPackDaoImpl().getTrackPack(productCode);
                        break;
                    default:
                        product = null; // handle unknown types
                }

                if (product != null) {
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all products", e);
            throw new RuntimeException("Database operation failed", e);
        }
        return products;
    }

    @Override
    public void updateProduct(Product product, Connection connection) {
        String sql = "UPDATE product SET brand_name = ?, product_name = ?, retail_price = ?, gauge_type = ? WHERE product_code = ?";
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Setting Parameters in Update Statements
            preparedStatement.setString(1, product.getBrandName());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setBigDecimal(3, product.getRetailPrice());
            preparedStatement.setString(4, product.getGaugeType().name());

            // The WHERE clause is used to specify the specific product to be updated, product_code is used here.
            preparedStatement.setString(5, product.getProductCode());

            // Implementation Updates
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating product failed, no rows affected.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating product in the database", e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public void deleteProduct(String productCode, Connection connection) {

        String sql = "DELETE FROM product WHERE product_code = ?";
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Setting the productCode parameter in a PreparedStatement
            preparedStatement.setString(1, productCode);

            // Performing a delete operation
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting product failed, no rows affected.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting product from the database", e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    public boolean checkProductCodeExists(String productCode) {
        String sql = "SELECT COUNT(*) FROM product WHERE product_code = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, productCode);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error checking if product code exists in the database", e);
            throw new RuntimeException("Database operation failed", e);
        }

        return false;
    }
}
