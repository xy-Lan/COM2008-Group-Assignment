package project.daoImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.daoimpl.ProductDaoImpl;
import project.model.product.Controller;
import project.model.product.abstractproduct.Product;
import project.service.MysqlService;

import java.math.BigDecimal;

public class ProductDaoImplTest {
    private ProductDaoImpl productDao;
    private MysqlService mysqlService;

    @BeforeEach
    public void setUp() {
        mysqlService = new MysqlService(); // 初始化您的数据库服务
        productDao = new ProductDaoImpl(mysqlService);
    }

//    @Test
//    public void testAddProduct() {
//        // 创建一个产品实例进行测试
//        Product product = new Controller("12345", "Test Brand", "Test Product", BigDecimal.valueOf(19.99), GaugeType.STANDARD); // 假设这是正确的构造函数
//
//        // 调用 addProduct 方法
//        productDao.addProduct(product);
//
//        // 验证产品是否被正确添加到数据库
//        // 这通常涉及到从数据库中检索刚刚添加的产品，并验证其属性
//        // ...
//    }
}
