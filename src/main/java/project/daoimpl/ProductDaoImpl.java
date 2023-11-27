package project.daoimpl;

import project.dao.*;
import project.model.product.*;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.Gauge;
import project.service.MysqlService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.*;

public class ProductDaoImpl implements ProductDao {
    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class.getName());

    private MysqlService mysqlService = new MysqlService();

    public ProductDaoImpl(MysqlService mysqlService) {
        this.mysqlService = mysqlService;
    }

    @Override
    public void addProduct(Product product, Connection connection) {
//        Connection connection = null;
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
        try (Connection connection = mysqlService.getConnection();
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
                        TrackDao trackDao = new TrackDaoImpl(mysqlService);
                        System.out.println("it is a track");
                        return new Track(productCode, brandName, productName, retailPrice, gaugeType, null);
                    case 'C':
                        ControllerDao controllerDao = new ControllerDaoImpl(mysqlService);
                        System.out.println("it is a controller");
                        return new Controller(productCode, brandName, productName, retailPrice, gaugeType, null, false);

                    case 'L':
                        LocomotiveDao locomotiveDao = new LocomotiveDaoImpl(mysqlService);
                        System.out.println("it is a locomotive");
                        return new Locomotive(productCode, brandName, productName, retailPrice, gaugeType, null, null);
                    case 'S':
                        RollingStockDao rollingStockDao = new RollingStockDaoImpl(mysqlService);
                        return new RollingStock(productCode, brandName, productName, retailPrice, gaugeType, null, null);
                    case 'M':
                        TrainSetDao trainSetDao = new TrainSetDaoImpl(mysqlService);
                        System.out.println("it is a TrainSet");
                        return new TrainSet(productCode, brandName, productName, retailPrice, gaugeType);
                    case 'P':
                        TrackPackDao trackPackDao = new TrackPackDaoImpl(mysqlService);
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
        try (Connection conn = mysqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String productCode = rs.getString("product_code");
                char firstChar = productCode.charAt(0);
                Product product;

                switch (firstChar) {
                    case 'R':
                        product = new TrackDaoImpl(mysqlService).getTrack(productCode);
                        break;
                    case 'C':
                        product = new ControllerDaoImpl(mysqlService).getController(productCode);
                        break;
                    case 'L':
                        product = new LocomotiveDaoImpl(mysqlService).getLocomotive(productCode);
                        break;
                    case 'S':
                        String productTypePrefix = productCode.length() >= 2 ? productCode.substring(0, 2) : "";
                        product = switch (productTypePrefix) {
                            case "SW" -> new WagonDaoImpl(mysqlService).getWagon(productCode);
                            case "SC" -> new CarriageDaoImpl(mysqlService).getCarriage(productCode);
                            default-> {
                                LOGGER.log(Level.WARNING, "Unknown rolling stock type: " + productTypePrefix);
                                yield null;
                            }
                        };
                        break;
                    case 'M':
                        product = new TrainSetDaoImpl(mysqlService).getTrainSet(productCode);
                        break;
                    case 'P':
                        product = new TrackPackDaoImpl(mysqlService).getTrackPack(productCode);
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
    public void updateProduct(Product product) {
        String sql = "UPDATE product SET brand_name = ?, product_name = ?, retail_price = ?, gauge_type = ? WHERE product_code = ?";
        try (Connection connection = mysqlService.getConnection();
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
    public void deleteProduct(String productCode) {
        String sql = "DELETE FROM product WHERE product_code = ?";
        try (Connection connection = mysqlService.getConnection();
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


    // Other necessary methods...
}
