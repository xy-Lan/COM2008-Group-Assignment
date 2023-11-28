package project.daoImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.OrderLineDao;
import project.daoimpl.OrderLineDaoImpl;
import project.model.order.OrderLine;
import project.service.MysqlService;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderLineDaoImplTest {
    private MysqlService mysqlService;
    private OrderLineDao orderLineDao;

    @BeforeEach
    void setUp() {
        mysqlService = new MysqlService();
        orderLineDao = new OrderLineDaoImpl(mysqlService);
    }

//    @Test
//    public void testGetAllOrderLines() {
//        int orderNumber = 123/* 预置在数据库中的订单号 */;
//        List<OrderLine> orderLines = orderLineDao.getAllOrderLines(orderNumber);
//
//        // 验证 - 确认返回了预期数量的订单行
//        assertNotNull(orderLines, "Order line list should not be null");
//        assertFalse(orderLines.isEmpty(), "Order line list should not be empty");
//
//        // 验证返回的每个订单行的具体内容
//        for (OrderLine orderLine : orderLines) {
//            assertEquals(orderNumber, orderLine.getOrderNumber(), "Order number should match");
//            // 进一步验证每个订单行的其他属性，如 productCode, quantity, linecost
//        }
//    }


//    test has been successful
//    @Test
//    void testAddOrderLine() {
//        OrderLine orderLine = new OrderLine("testProductCode", 1, new BigDecimal("10.00"), 123);
//
//        orderLineDao.addOrderLine(orderLine);
//
//    }

//    test has been successful
//    @Test
//    void testGetOrderLine() {
//
//        int testOrderNumber = 123;
//        String testProductCode = "testProductCode";
//
//
//        OrderLine result = orderLineDao.getOrderLine(testOrderNumber, testProductCode);
//
//
//        assertNotNull(result);
//        assertEquals(testProductCode, result.getProductCode());
//        assertEquals(testOrderNumber, result.getOrderNumber());
//
//    }
//@Test
//void testUpdateOrderLine() {
//    OrderLine orderLine = new OrderLine("testProductCode", 3 , new BigDecimal("20.00"), 123);
//
//    orderLineDao.updateOrderLine(orderLine);
//
//    OrderLine retrievedOrderLine = orderLineDao.getOrderLine(123, "testProductCode");
//
//    assertNotNull(retrievedOrderLine, "OrderLine should not be null");
//    assertEquals(3, retrievedOrderLine.getQuantity(), "Quantity should be updated to 2");
//}

//     test has been successful
//    @Test
//    void testDeleteOrderLine() {
//        int testOrderNumber = 123;
//        String testProductCode = "testProductCode";
//
//        orderLineDao.deleteOrderLine(testOrderNumber, testProductCode);
//
//    }
}
