package project.dao;

import java.util.List;

import project.model.inventory.Inventory;

public interface InventoryDao {
    // Method to increase the stock of a product
    void increaseStock(String productCode, int newShipmentQuantity);

    // Method to decrease the stock of a product
    void decreaseStock(String productCode, int quantityDecrease);

    // Method to check the current stock of all products
    List<Inventory> checkStock();
    public Integer getStock (String productCode);
}
