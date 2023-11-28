package project.service;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;

import project.model.user.*;

import project.dao.InventoryDao;
import project.model.inventory.Inventory;
import project.model.user.Role;

public class InventoryService {

    private InventoryDao inventoryDao;

    private User updater;

    private List<Inventory> inventories;

    // Additional parameters may be required
    private void checkStaffRole() {
        if (!updater.hasRole(Role.STAFF)) {
            throw new UnsupportedOperationException("Only staff can perform this operation.");
        }
    }

    // Additional parameters may be required
    public Boolean increaseStock(String productCode, int newShipmentQuantity) {
        checkStaffRole();

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
                PreparedStatement pstmt = con.prepareStatement("UPDATE `inventory` SET `quantity` = `quantity` + ? WHERE `product_code` = ?")
        ) {
            pstmt.setInt(1, newShipmentQuantity);
            pstmt.setString(2, productCode);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Additional parameters may be required
    public Boolean decreaseStock(String productCode, int quantityDecrease) {
        checkStaffRole();

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
                PreparedStatement pstmt = con.prepareStatement("UPDATE `inventory` SET `quantity` = `quantity` - ? WHERE `product_code` = ?")
        ) {
            pstmt.setInt(1, quantityDecrease);
            pstmt.setString(2, productCode);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Additional parameters may be required
    public void checkStock() {
        checkStaffRole();
        // TODO - implement Inventory.checkStock
    }
}
