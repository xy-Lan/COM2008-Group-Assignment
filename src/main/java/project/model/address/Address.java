package project.model.address;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import project.model.user.*;

public class Address {

//	Collection<User> users = new ArrayList<>();
	private String houseNumber;
	private String postCode;
	private String roadName;
	private String cityName;
    private int addressId;

    public void setPreparedStatement(PreparedStatement stmt) throws SQLException {
        stmt.setString(1, this.houseNumber);
        stmt.setString(2, this.postCode);
        stmt.setString(3, this.roadName);
        stmt.setString(4, this.cityName);
    }

    // Static method to create an Address instance from a ResultSet
    public static Address fromResultSet(ResultSet rs) throws SQLException {
        Address address = new Address();
        address.setHouseNumber(rs.getString("house_number")); 
        address.setPostCode(rs.getString("post_code"));       
        address.setRoadName(rs.getString("road_name"));       
        address.setCityName(rs.getString("city_name"));       
    
        return address;
    }

//	public Collection<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Collection<User> users) {
//        this.users = users;
//    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
	
}