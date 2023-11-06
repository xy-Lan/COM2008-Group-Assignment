package com.system.model.inventory;
import com.system.model.user.*;
import java.sql.*;

public class Inventory {

	private String updaterID;
	private String productCode;
	private Integer quantity;
	private User updater;

	private void checkStaffRole() {
        if (!updater.hasRole(Role.STAFF)) {
            throw new UnsupportedOperationException("Only staff can perform this operation.");
        }
    }

    public static void increaseStock(String productCode, int newQuantity) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
        
            String updateQuery = "UPDATE `inventory` SET quantity = ? WHERE product_code = ?";
            pstmt = con.prepareStatement(updateQuery);
            pstmt.setInt(1, newQuantity);
            pstmt.setString(2, productCode);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Stock updated successfully.");
            } else {
                System.out.println("Product not found or no changes made.");
            } 
        }
        catch (SQLException ex) { // Catch SQLException
            ex.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if (pstmt != null) 
                    pstmt.close();
                if (con != null) 
                    con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
        
        
        
        
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if (con != null) con.close();
        }
    }

    public void decreaseStock() {
        checkStaffRole();
        // TODO - implement Inventory.decreaseStock
    }

    public void checkStock() {
        checkStaffRole();
        // TODO - implement Inventory.checkStock
    }

}