package project.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
    public void increaseStock(String productCode, int newShipmentQuantity) {
        checkStaffRole();

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
                PreparedStatement pstmt = con.prepareStatement("UPDATE `inventory` SET `quantity` = `quantity` + ? WHERE `product_code` = ?")
        ) {
            pstmt.setInt(1, newShipmentQuantity);
            pstmt.setString(2, productCode);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Change Successful");
            } else {
                System.out.println("Change Unsuccessful");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Additional parameters may be required
    public void decreaseStock(String productCode, int quantityDecrease) {
        checkStaffRole();

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
                PreparedStatement pstmt = con.prepareStatement("UPDATE `inventory` SET `quantity` = `quantity` + ? WHERE `product_code` = ?")
        ) {
            pstmt.setInt(1, quantityDecrease);
            pstmt.setString(2, productCode);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Change Successful");
            } else {
                System.out.println("Change Unsuccessful");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Additional parameters may be required
    public void checkStock() {
        checkStaffRole();
        // TODO - implement Inventory.checkStock
    }
}
