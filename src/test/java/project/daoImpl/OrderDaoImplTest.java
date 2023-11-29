package project.daoImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

@ExtendWith(MockitoExtension.class)
public class OrderDaoImplTest {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private OrderDaoImpl orderDao =new OrderDaoImpl();

    @BeforeEach
    public void setUp() {
        orderDao = new OrderDaoImpl();
    }

//    @Test
//    public void testUpdateOrderStatus() {
//        int orderNumber = 125;
//        Order order = new Order(new User(123));
//        order.setOrderNumber(orderNumber);
//        order.setOrderStatus(OrderStatus.CONFIRMED);
//
//        orderDao.updateOrderStatus(order);
//
//        Optional<Order> updatedOrder = orderDao.getOrderById(orderNumber);
//        System.out.println(updatedOrder.get().getOrderStatus().name());
//        assertTrue(updatedOrder.isPresent(), "Order should exist");
//        assertEquals(OrderStatus.CONFIRMED, updatedOrder.get().getOrderStatus(), "Order status should be updated");
//    }

//    @Test
//    public void testDeleteExistingOrder() {
//        int orderNumber = 124;
//
//        // 执行删除操作
//        orderDao.deleteOrder(orderNumber);
//
//        // 验证订单是否已被删除
//        Optional<Order> deletedOrder = orderDao.getOrderById(orderNumber);
//        assertFalse(deletedOrder.isPresent(), "Order should not exist after deletion");
//    }

//    @Test
//    public void testDeleteNonExistingOrder() {
//        int orderNumber = 1234/* 一个不存在的订单号 */;
//
//        // 执行删除操作
//        orderDao.deleteOrder(orderNumber);
//
//        // 由于订单不存在，不需要额外的验证
//        // 可以考虑检查日志或其他异常处理
//    }

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
    public void testGetOrdersByUserId() {
        int userId = 2;
        List<Order> orders = orderDao.getOrdersByUserId(userId);

        assertNotNull(orders, "Order list should not be null");
        assertFalse(orders.isEmpty(), "Order list should not be empty");

        for (Order order : orders) {
            System.out.println("it is " +order.getOrderStatus().name());
            assertNotEquals("PENDING", order.getOrderStatus().name(), "Order status should not be PENDING");

        }

         assertEquals(3, orders.size());
    }

//    @Test
//    public void testGetAllOrders() {
//        List<Order> orders = orderDao.getAllOrders();
//
//        assertNotNull(orders, "Order list should not be null");
//        assertFalse(orders.isEmpty(), "Order list should not be empty");
//
//         assertEquals(10, orders.size());
//    }


//    @Test
//    public void testGetOrderById_ExistingOrder() {
//        int orderNumber = 125;
//        Optional<Order> result = orderDao.getOrderById(orderNumber);
//        assertTrue(result.isPresent(), "Order should be found");
//        assertEquals(orderNumber, result.get().getOrderNumber(), "Order number should match");
//        assertEquals(OrderStatus.CONFIRMED, result.get().getOrderStatus(), "Order status should match");
//    }

//    @Test
//    public void testGetOrderById_NonExistingOrder() {
//        int orderNumber = 1234;
//        Optional<Order> result = orderDao.getOrderById(orderNumber);
//        assertFalse(result.isPresent(), "Order should not be found");
//    }
//
//    @Test
//    public void testGetPendingOrderByUserId_ExistingOrder() {
//        int userId = 123;
//        Optional<Order> result = orderDao.getPendingOrderByUserId(userId);
//        assertTrue(result.isPresent(), "Pending order should be found for the user");
//        assertEquals(userId, result.get().getUser().getUserID(), "User ID should match");
//        assertEquals("PENDING", result.get().getOrderStatus().name(), "Order status should be PENDING");
//    }
//
//    @Test
//    public void testGetPendingOrderByUserId_NoPendingOrder() {
//        int userId = 2;
//        Optional<Order> result = orderDao.getPendingOrderByUserId(userId);
//        assertFalse(result.isPresent(), "No pending order should be found for the user");
//    }
}
