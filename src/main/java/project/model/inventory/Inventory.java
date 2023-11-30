package project.model.inventory;
import project.dao.UserDao;
import project.model.user.*;
import java.sql.*;
import java.util.Optional;

public class Inventory {


	private String productCode;
	private Integer quantity;

    public Inventory(String productCode, Integer quantity) {
        this.productCode = productCode;
        this.quantity = quantity;
    }


    // Constructor of Inventory


     // Static method to create an Inventory instance from a ResultSet
    public static Inventory fromResultSet(ResultSet resultSet, UserDao userDao) throws SQLException {

        String productCode = resultSet.getString("product_code");
        Integer quantity = resultSet.getInt("quantity");

        // Use Optional to handle a potentially null User
        //Returns null if Optional is null
        return new Inventory(productCode, quantity);
    }



	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


//	private void checkStaffRole() {
//        if (!updater.hasRole(Role.STAFF)) {
//            throw new UnsupportedOperationException("Only staff can perform this operation.");
//        }
//    }

	/*increaseStock and decreaseStock are complext bussiness logic
	* and should move to UserService.java*/
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

//    public void checkStock() {
//        checkStaffRole();
//        // TODO - implement Inventory.checkStock
//    }

}