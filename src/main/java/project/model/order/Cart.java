package project.model;

import project.model.product.abstractproduct.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        // Add product to the cart or update quantity...
    }

    public void removeProduct(Product product) {
        // Remove product from the cart...
    }
}
