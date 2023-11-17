package project.dao;

import project.model.product.abstractproduct.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    Product getProduct(String productCode);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    void deleteProduct(String productCode);
}
