package project.daoimpl;

import project.dao.ProductDao;
import project.model.product.*;
import project.model.product.abstractproduct.Product;
import project.service.MysqlService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.*;

public class ProductDaoImpl implements ProductDao {
    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class.getName());

    private MysqlService mysqlService;

    public ProductDaoImpl (MysqlService mysqlService) {
        this.mysqlService = mysqlService;
    }

    @Override
    public void addProduct(Product product) {
        String sql = "INSERT INTO product (product_code, brand_name, product_name,retail_price, gauge_type) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = mysqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getProductCode());
            preparedStatement.setString(2, product.getBrandName());
            preparedStatement.setString(3, product.getProductName());
            preparedStatement.setBigDecimal(4, product.getRetailPrice());
            preparedStatement.setString(5, product.getGaugeType().name());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding product to the database", e);
            throw new RuntimeException("Database operation failed", e);
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
                char firstChar = productCode.charAt(0);
                switch (firstChar) {
                    case 'R':
                        return Track.fromResultSet(resultSet);
                    case 'C':
                        return Controller.fromResultSet(resultSet);
                    case 'L':
                        return Locomotive.fromResultSet(resultSet);
                    case 'S':
                        String productTypePrefix = productCode.length() >= 2 ? productCode.substring(0, 2) : "";
                        return switch (productTypePrefix) {
                            case "SW" -> Wagon.fromResultSet(resultSet);
                            case "SC" -> Carriage.fromResultSet(resultSet);
                            default -> throw new IllegalArgumentException("Unknown rolling stock type: " + productTypePrefix);
                        };
                    case 'M':
                        return TrainSet.fromResultSet(resultSet);
                    case 'P':
                        return TrackPack.fromResultSet(resultSet);
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
                        product = Track.fromResultSet(rs);
                        break;
                    case 'C':
                        product = Controller.fromResultSet(rs);
                        break;
                    case 'L':
                        product = Locomotive.fromResultSet(rs);
                        break;
                    case 'S':
                        String productTypePrefix = productCode.length() >= 2 ? productCode.substring(0, 2) : "";
                        product = switch (productTypePrefix) {
                            case "SW" -> Wagon.fromResultSet(rs);
                            case "SC" -> Carriage.fromResultSet(rs);
                            default -> {
                                LOGGER.log(Level.WARNING, "Unknown rolling stock type: " + productTypePrefix);
                                yield null;
                            }
                        };
                        break;
                    case 'M':
                        product = TrainSet.fromResultSet(rs);
                        break;
                    case 'P':
                        product = TrackPack.fromResultSet(rs);
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
