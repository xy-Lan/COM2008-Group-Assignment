package project.daoImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.OrderLineDao;
import project.daoimpl.OrderLineDaoImpl;
import project.model.order.OrderLine;
import project.service.MysqlService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderLineDaoImplTest {
    private MysqlService mysqlService;
    private OrderLineDao orderLineDao;

    @BeforeEach
    void setUp() {
        mysqlService = new MysqlService();
        orderLineDao = new OrderLineDaoImpl(mysqlService);
    }

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
//        // 定义测试用的 orderNumber 和 productCode
//        int testOrderNumber = 123; // 这些值应该与您插入的测试数据匹配
//        String testProductCode = "testProductCode";
//
//        // 执行测试
//        OrderLine result = orderLineDao.getOrderLine(testOrderNumber, testProductCode);
//
//        // 验证结果
//        assertNotNull(result);
//        assertEquals(testProductCode, result.getProductCode());
//        assertEquals(testOrderNumber, result.getOrderNumber());
//        // 还可以验证其他字段，如 quantity 和 lineCost
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
}
