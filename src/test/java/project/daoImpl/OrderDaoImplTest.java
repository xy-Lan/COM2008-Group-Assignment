package project.daoImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import project.daoimpl.OrderDaoImpl;
import project.model.order.Order;
import project.model.order.OrderStatus;
import project.model.user.User;
import project.service.MysqlService;

@ExtendWith(MockitoExtension.class)
public class OrderDaoImplTest {


    private MysqlService mysqlService = new MysqlService();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private OrderDaoImpl orderDao =new OrderDaoImpl(mysqlService);

    @BeforeEach
    public void setUp() {
        // 初始化OrderDao
        orderDao = new OrderDaoImpl(mysqlService);
    }

//    @Test
//    public void testAddOrder() throws SQLException {
//        User user = new User("xy-Lan@gmail.com");
//        user.setUserID(123);
//
//        Order order = new Order(user);
//        System.out.println("Testing addOrder...");
//
//        orderDao.addOrder(order);
//
//    }

    @Test
    public void testGetOrderById_ExistingOrder() {
        int orderNumber = 125;
        Optional<Order> result = orderDao.getOrderById(orderNumber);
        assertTrue(result.isPresent(), "Order should be found");
        assertEquals(orderNumber, result.get().getOrderNumber(), "Order number should match");
    }

    @Test
    public void testGetOrderById_NonExistingOrder() {
        int orderNumber = 1234;
        Optional<Order> result = orderDao.getOrderById(orderNumber);
        assertFalse(result.isPresent(), "Order should not be found");
    }

    @Test
    public void testGetPendingOrderByUserId_ExistingOrder() {
        int userId = 123;
        Optional<Order> result = orderDao.getPendingOrderByUserId(userId);
        assertTrue(result.isPresent(), "Pending order should be found for the user");
        assertEquals(userId, result.get().getUser().getUserID(), "User ID should match");
        assertEquals("PENDING", result.get().getOrderStatus().name(), "Order status should be PENDING");
    }

    @Test
    public void testGetPendingOrderByUserId_NoPendingOrder() {
        int userId = 2;
        Optional<Order> result = orderDao.getPendingOrderByUserId(userId);
        assertFalse(result.isPresent(), "No pending order should be found for the user");
    }
}
