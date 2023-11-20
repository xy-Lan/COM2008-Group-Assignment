package project.daoImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import project.daoimpl.OrderDaoImpl;
import project.model.order.Order;
import project.model.order.OrderStatus;
import project.model.user.User;
import project.service.MysqlService;


public class OrderDaoImplTest {

    @Mock
    private MysqlService mysqlService;
    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockStatement;
    @Mock
    private ResultSet mockResultSet;

    private OrderDaoImpl orderDao;
    private Order dummyOrder;

    @BeforeEach
    public void setUp() throws SQLException {
        mysqlService = new MysqlService(); 
        System.out.println("mysqlService in setUp: " + mysqlService);
        // Setup dummy data and mock behaviors
       
        dummyOrder = new Order();
        dummyOrder.setUser(new User("user@example.com"));
        dummyOrder.setOrderStatus(OrderStatus.PENDING);
        dummyOrder.setOrderLines(new ArrayList<>());

        when(mysqlService.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString(), anyInt())).thenReturn(mockStatement);
        when(mockStatement.getGeneratedKeys()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(1); // Simulate auto-generated key

        orderDao = new OrderDaoImpl(mysqlService);


    }

//    @Test
//    public void addOrder_ShouldInsertOrder() throws SQLException {
//        when(mockStatement.executeUpdate()).thenReturn(1);
//
//        orderDao.addOrder(dummyOrder);
//
//        verify(mockStatement, times(1)).executeUpdate();
//        assertNotNull(dummyOrder.getOrderNumber()); // Assuming setOrderNumber sets some value
//    }

//    @Test
//    public void addOrder_ShouldThrowException_WhenNoRowsAffected() throws SQLException {
//        when(mockStatement.executeUpdate()).thenReturn(0);
//
//        Exception exception = assertThrows(RuntimeException.class, () -> {
//            orderDao.addOrder(dummyOrder);
//        });
//
//        String expectedMessage = "Creating order failed, no rows affected.";
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
}
