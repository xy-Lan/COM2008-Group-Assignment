package project.daoImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.daoimpl.ProductDaoImpl;
import project.model.product.Controller;
import project.model.product.abstractproduct.Product;
import project.service.MySqlService;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductDaoImplTest {
    private ProductDaoImpl productDao;



    @BeforeEach
    void setUp() {
        // 准备数据库连接和DAO
        productDao = new ProductDaoImpl();
        // 插入测试数据
        // ...
    }

    @Test
    void testGetAllProducts() {
        // 调用方法
        List<Product> products = productDao.getAllProducts();

        // 断言：检查列表是否包含所有类型的产品
        // ...
        assertNotNull(products);
        assertFalse(products.isEmpty());
        // 进一步断言来检查产品类型和数据
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
