package project.model.inventory;
import project.model.user.*;
import java.sql.*;

public class Inventory {

	private String updaterID;
	private String productCode;
	private Integer quantity;
	private User updater;

//	private void checkStaffRole() {
//        if (!updater.hasRole(Role.STAFF)) {
//            throw new UnsupportedOperationException("Only staff can perform this operation.");
//        }
//    }
//
//    public void increaseStock(String productCode, int newShipmentQuantity) {
//        checkStaffRole();
//
//        try (
//            Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
//            PreparedStatement pstmt = con.prepareStatement("UPDATE `inventory` SET `quantity` = `quantity` + ? WHERE `product_code` = ?")
//        ) {
//            pstmt.setInt(1, newShipmentQuantity);
//            pstmt.setString(2, productCode);
//            int rowsUpdated = pstmt.executeUpdate();
//
//            if (rowsUpdated > 0) {
//                System.out.println("Change Successful");
//            } else {
//                System.out.println("Change Unsuccessful");
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//
//
//    public void decreaseStock(String productCode, int quantityDecrease) {
//        checkStaffRole();
//
//        try (
//            Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
//            PreparedStatement pstmt = con.prepareStatement("UPDATE `inventory` SET `quantity` = `quantity` + ? WHERE `product_code` = ?")
//        ) {
//            pstmt.setInt(1, quantityDecrease);
//            pstmt.setString(2, productCode);
//            int rowsUpdated = pstmt.executeUpdate();
//
//            if (rowsUpdated > 0) {
//                System.out.println("Change Successful");
//            } else {
//                System.out.println("Change Unsuccessful");
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void checkStock() {
//        checkStaffRole();
//        // TODO - implement Inventory.checkStock
//    }

}