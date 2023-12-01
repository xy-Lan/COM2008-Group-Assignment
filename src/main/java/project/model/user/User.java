package project.model.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.model.address.*;
import project.model.inventory.Inventory;
import project.model.order.*;

import project.service.MySqlService;

public class User {

	private List<Role> roles = new ArrayList<>();
	private String email;
	private int userID;
	private String forename;
	private String surname;
	private int addressId;
//	private String houseNumber;
//	private String postCode;
//	// Used only when the user is Staff
//	private List<Inventory> inventories = new ArrayList<>();
//	// Used only when the user is Customer
//	private List<Payment> payments = new ArrayList<>();
//	private List<Order> orders = new ArrayList<>();
//	private Address residesAt;

	public static User fromResultSet(ResultSet resultSet) throws SQLException {
		int userId = resultSet.getInt("user_id");
		User user = new User(userId);

		user.setEmail(resultSet.getString("email"));
		user.setUserID(resultSet.getInt("user_id"));
		user.setForename(resultSet.getString("forename"));
		user.setSurname(resultSet.getString("surname"));
		user.setAddressId(resultSet.getInt("address_id"));

		System.out.println("Found " + user.addressId);

		return user;
	}

	public User() {}

	public User(String email) {
		this.email= email;
	}

	public User(int userID) {
		this.userID = userID;
	}



	public void prepareStatement(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, this.getEmail());
		preparedStatement.setString(2, this.getForename());
		preparedStatement.setString(3, this.getSurname());
		preparedStatement.setInt(4, this.getAddressId());
		preparedStatement.setInt(5, this.getUserID());
	}

	public void setUserID(int id) {
		userID = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setEmail(String _email) {
		email = _email;
	}

	public String getEmail() {
		return email;
	}



	// Getter and Setter for forename
	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	// Getter and Setter for surname
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setAddressId(int addressId) { this.addressId = addressId; }

	public int getAddressId() { return addressId; }
//	public void setSurname(String surname) {
//		this.surname = surname;
//	}
//
//	// Getter and Setter for houseNumber
//	public String getHouseNumber() {
//		return houseNumber;
//	}
//
//	public void setHouseNumber(String houseNumber) {
//		this.houseNumber = houseNumber;
//	}
//
//	// Getter and Setter for postCode
//	public String getPostCode() {
//		return postCode;
//	}

//	public void setPostCode(String postCode) {
//		this.postCode = postCode;
//	}

	public List<Role> getRoles() {
		return roles;
	}


//	public void setOrders (List<Order> orders){ this.orders = orders; }
//	public List<Order> getOrders(){ return orders; }

	public void updateDetails() {
		// TODO - implement User.updateDetails
		throw new UnsupportedOperationException();
	}

	public void selfRegister() {
		// TODO - implement User.selfRegister
		throw new UnsupportedOperationException();
	}

	public void viewOrders() {
		// TODO - implement Customer.viewOrders
		throw new UnsupportedOperationException();
	}

	/**
	 * Checks if the user has the specified role.
	 *
	 * @param role The role to check for.
	 * @return {@code true} if the user has the given role, {@code false} otherwise.
	 */
	public boolean hasRole(Role role) {
		return roles.contains(role);
	}

	/**
	 * Adds the specified role to the user.
	 * If the user already has the role, it will not be added again.
	 *
	 * @param role The role to add.
	 */
	public void addRole(Role role) {
		if (!roles.contains(role)) {
			roles.add(role);
		}


	}

	/**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'STAFF' role in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void viewPendingOrders() {
		
		try (
			Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM orders");
			ResultSet resultSet = pstmt.executeQuery()) {
			
				while (resultSet.next()) {
					int column1Value = resultSet.getInt("order_number");
					String column2Value = resultSet.getString("date");
					String column3Value = resultSet.getString("user_id");
					String column4value = resultSet.getString("status");

					System.out.println("Order Number: " + column1Value + ", Date: " + column2Value + ", User ID: " + column3Value + ", Status: " + column4value);	
				}
		
		} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}

	/**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'CUSTOMER' role
	 * in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void updateBankingDetails() {
		// TODO - implement Customer.updateBankingDetails
		throw new UnsupportedOperationException();
	}

	/**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'CUSTOMER' role
	 * in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void addCard() {
		// TODO - implement Customer.addCard
		throw new UnsupportedOperationException();
	}

	/**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'CUSTOMER' role
	 * in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void removeCard() {
		// TODO - implement Customer.removeCard
		throw new UnsupportedOperationException();
	}

	/**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'MANAGER' role in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void appointUserAsStaff() {
		// TODO - implement Manager.appointUserAsStaff
		throw new UnsupportedOperationException();
	}

	/**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'MANAGER' role in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void removeUserFromStaff() {
		// TODO - implement Manager.removeUserFromStaff
		throw new UnsupportedOperationException();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();

		map.put("email", email);
		map.put("userId", userID);

		return map;

	}

	public void updateDatabase() {

		try {
			MySqlService mySqlService = MySqlService.getInstance();
			Connection con = mySqlService.getConnection();

			String sql = "UPDATE users SET email = ?, forename = ?, surname = ?, " + "house_number = ?, post_code = ?, role = ? WHERE user_id = ?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, getEmail());
			preparedStatement.setString(2, ""); 
			preparedStatement.setString(3, "");
			preparedStatement.setString(4, "");
			preparedStatement.setString(5, "");
			preparedStatement.setString(6, ""); 
			preparedStatement.setInt(7, userID);

			preparedStatement.executeUpdate();

			System.out.println("User details updated successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}