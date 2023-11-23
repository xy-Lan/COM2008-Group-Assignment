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


    @Test
    public void testAddOrder() throws SQLException {
        User user = new User("laister.sam@gmail.com");
        user.setUserID(1);

        Order order = new Order(user);
        System.out.println("Testing addOrder...");

        orderDao.addOrder(order);

    }
}
