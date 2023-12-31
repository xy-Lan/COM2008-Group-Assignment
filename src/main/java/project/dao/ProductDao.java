package project.dao;

import project.model.product.abstractproduct.Product;

import java.sql.Connection;
import java.util.List;

public interface ProductDao {
    void addProduct(Product product, Connection connection);
    Product getProduct(String productCode);
    List<Product> getAllProducts();
    void updateProduct(Product product, Connection connection);
    void deleteProduct(String productCode, Connection connection);
}
