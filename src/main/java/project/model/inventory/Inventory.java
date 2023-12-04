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


    public static Inventory fromResultSet(ResultSet resultSet, UserDao userDao) throws SQLException {

        String productCode = resultSet.getString("product_code");
        Integer quantity = resultSet.getInt("quantity");

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

}