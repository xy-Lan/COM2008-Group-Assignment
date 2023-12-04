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

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setAddressId(int addressId) { this.addressId = addressId; }

	public int getAddressId() { return addressId; }


	public List<Role> getRoles() {
		return roles;
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

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();

		map.put("email", email);
		map.put("userId", userID);

		return map;

	}


}