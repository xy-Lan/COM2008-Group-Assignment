package project.daoImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import project.dao.AddressDao;
import project.daoimpl.AddressDaoImpl;
import project.model.address.Address;
import project.service.MySqlService;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressDaoImplTest {

    private AddressDao addressDao;

    @BeforeEach
    public void setUp() throws SQLException {
        addressDao = new AddressDaoImpl();
    }

    @Test
    public void testAddAddressIfNotExist_NewAddress() {
        Address newAddress = new Address();
        newAddress.setHouseNumber("TestHouse123");
        newAddress.setPostCode("TestPost123");
        newAddress.setRoadName("TestRoad");
        newAddress.setCityName("TestCity");
        Integer addressId = addressDao.addAddressIfNotExist(newAddress);
        System.out.println(addressId);

        assertNotNull(addressId, "Method should return a new address ID for a new address");
    }

    @Test
    public void testAddAddress_NewAddress() {
        Address newAddress = new Address();
        newAddress.setHouseNumber("wer");
        newAddress.setPostCode("12ww");
        newAddress.setRoadName("Test Road");
        newAddress.setCityName("Test city");
        System.out.println(addressDao.addAddressReturnId(newAddress));
    }

    @Test
    public void testGetAddressId_WhenAddressDoesNotExist() {

        Integer retrievedId = addressDao.getAddressId("NonExistingHouse", "NonExistingPost");

        assertNull(retrievedId, "Method should return null for non-existing address");
    }

    @Test
    public void testGetAddressId_WhenAddressExists() {

        Integer retrievedId = addressDao.getAddressId("protobello", "S1 4AT");

        assertEquals(1, retrievedId, "Method should return the correct address ID for existing address");
    }

    @Test
    public void testGetAddressById() throws SQLException {
        int addressId = insertTestAddress();

        Address address = addressDao.getAddress(addressId);

        assertNotNull(address);
        assertEquals("100", address.getHouseNumber());
        assertEquals("12345", address.getPostCode());
        assertEquals("Test Road", address.getRoadName());
        assertEquals("Test City", address.getCityName());
    }



    private int insertTestAddress() throws SQLException {
        String insertSql = "INSERT INTO address (house_number, post_code, road_name, city_name) VALUES ('100', '12345', 'Test Road', 'Test City')";
        int addressId = 0;

        try (Connection conn = MySqlService.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(insertSql, Statement.RETURN_GENERATED_KEYS);

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    addressId = generatedKeys.getInt(1);
                }
            }
        }
        return addressId;
    }

    @Test
    public void testGetAllAddresses() throws SQLException {
        try (Connection conn = MySqlService.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("INSERT INTO address (house_number, post_code, road_name, city_name) VALUES ('101', '12345', 'Test Road 1', 'Test City')");
            stmt.execute("INSERT INTO address (house_number, post_code, road_name, city_name) VALUES ('102', '54321', 'Test Road 2', 'Test City')");
        }

        List<Address> addresses = addressDao.getAllAddresses();

        assertNotNull(addresses);
        assertTrue(addresses.size() >= 2);


        try (Connection conn = MySqlService.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM address WHERE house_number IN ('101', '102')");
        }
    }


    @AfterEach
    public void tearDown() throws SQLException {
        try (Connection conn = MySqlService.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM address WHERE house_number = '123' AND post_code = '12345'");
            stmt.execute("DELETE FROM address WHERE house_number = '100' AND post_code = '12345'");
        }
    }


}

