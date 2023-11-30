package project.daoimpl;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import project.dao.InventoryDao;
import project.model.inventory.Inventory;
import project.service.MySqlService;

public class InventoryDaoImpl implements InventoryDao {
    private static final Logger LOGGER = Logger.getLogger(InventoryDaoImpl.class.getName());

    @Override
    public void increaseStock(String productCode, int newShipmentQuantity) {
        String sql = "UPDATE inventory SET quantity = quantity + ? WHERE product_code = ?";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newShipmentQuantity);
            stmt.setString(2, productCode);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                LOGGER.log(Level.WARNING, "No inventory record found for product code: " + productCode);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating inventory for product code: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public void decreaseStock(String productCode, int quantityDecrease) {
        String sql = "UPDATE inventory SET quantity = GREATEST(0, quantity - ?) WHERE product_code = ?";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, quantityDecrease);
            stmt.setString(2, productCode);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                LOGGER.log(Level.WARNING, "No inventory record found for product code: " + productCode);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating inventory for product code: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public List<Inventory> checkStock() {
        List<Inventory> inventoryList = new ArrayList<>();
        String sql = "SELECT product_code, quantity FROM inventory";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String productCode = rs.getString("product_code");
                int quantity = rs.getInt("quantity");

                Inventory inventory = new Inventory(productCode, quantity);
                inventoryList.add(inventory);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving inventory from database", e);
            throw new RuntimeException("Database operation failed", e);
        }

        return inventoryList;
    }

    public Integer getStock (String productCode) {
        String sql = "SELECT quantity FROM inventory WHERE product_code = ?";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, productCode);
            System.out.println(pstmt);
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
