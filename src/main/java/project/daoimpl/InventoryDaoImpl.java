package project.daoimpl;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.util.logging.Level;

import project.dao.InventoryDao;
import project.model.inventory.Inventory;
import project.service.MysqlService;

public class InventoryDaoImpl implements InventoryDao {

    private MysqlService mysqlService = new MysqlService();

    public InventoryDaoImpl(MysqlService mysqlService) {
        this.mysqlService = mysqlService;
    }
    @Override
    public void increaseStock(String productCode, int newShipmentQuantity) {
        // Implementation for increasing stock
        // Similar to your existing increaseStock method in the Inventory class
    }

    @Override
    public void decreaseStock(String productCode, int quantityDecrease) {
        // Implementation for decreasing stock
        // Similar to your existing decreaseStock method in the Inventory class
    }

    @Override
    public List<Inventory> checkStock() {
        // Implementation to check current stock
        // This method would query the database and return a list of InventoryItem objects
        return new ArrayList<>();
    }

    public Integer getStock (String productCode) {
        String sql = "SELECT quantity FROM inventory WHERE product_code = ?";

        try (Connection conn = mysqlService.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, productCode);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("quantity");
                } else {
                    System.out.println("Product not found.");
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error accessing the database", e);
        }
    }


}
