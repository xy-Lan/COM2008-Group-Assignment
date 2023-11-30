package project.daoImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.ControllerDao;
import project.dao.PartDao;
import project.dao.ProductDao;
import project.daoimpl.ControllerDaoImpl;
import project.daoimpl.PartDaoImpl;
import project.daoimpl.ProductDaoImpl;
import project.model.product.Controller;
import project.model.product.enums.ControllerType;
import project.model.product.enums.Gauge;
import project.service.MySqlService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerDaoImplTest {
    private ControllerDao controllerDao;
    private ProductDao productDao;
    private static final Logger LOGGER = Logger.getLogger(ControllerDaoImplTest.class.getName());
    @BeforeEach
    public void setUp() {
        controllerDao = new ControllerDaoImpl();
        productDao = new ProductDaoImpl();
    }

//    @Test
//    public void testUpdateController() {
//        String productCode = "C122";
//        Controller testController = new Controller("C122", "testBrand", "testName", new BigDecimal("99.99"), Gauge.TT_GAUGE, ControllerType.STANDARD_CONTROLLER, true);
//
//        // 执行更新操作
//        controllerDao.updateController(testController);
//    }

    @Test
    public void testDeleteController() {
        String productCode = "C100"; // 测试用的 productCode

        // 执行删除操作
        controllerDao.deleteController(productCode);

        // 验证控制器是否已被删除
        assertNull(controllerDao.getController(productCode), "Controller should be null after deletion");

        // 验证相关联的部件和产品是否已被删除
        // 假设你有方法来检查这些
//        assertNull(partDao.getPartByProductCode(productCode), "Part should be null after deletion");
        assertNull(productDao.getProduct(productCode), "Product should be null after deletion");
    }

    @Test
    void testAddController() {
        Controller testController = new Controller("C100", "testBrand", "testName", new BigDecimal("99.99"), Gauge.TT_GAUGE, ControllerType.STANDARD_CONTROLLER, true);

        assertDoesNotThrow(() -> controllerDao.addController(testController));

    }

    @Test
    void testGetController() {
        String testProductCode = "C122";
//        Controller testController = new Controller("testCode2", "testBrand", "testName", new BigDecimal("99.99");
        Controller controller = controllerDao.getController(testProductCode);

        assertNotNull(controller);
        assertEquals(testProductCode, controller.getProductCode());

    }

    @Test
    public void testGetAllControllers() {
        List<Controller> controllers = controllerDao.getAllControllers();
        assertNotNull(controllers, "Controllers list should not be null");
        Assertions.assertFalse(controllers.isEmpty(), "Controllers list should not be empty");

        boolean hasProductCodeC122 = controllers.stream()
                .anyMatch(controller -> "C122".equals(controller.getProductCode()));
        Assertions.assertTrue(hasProductCodeC122, "Controllers list should contain a controller with productCode 'C122'");

        boolean hasProductCodeC123 = controllers.stream()
                .anyMatch(controller -> "C123".equals(controller.getProductCode()));
        Assertions.assertTrue(hasProductCodeC123, "Controllers list should contain a controller with productCode 'C123'");
    }


    @AfterEach
    void tearDown() {
        String deleteSqlProduct = "DELETE FROM product WHERE product_code = 'C100'";
        String deleteSqlPart = "DELETE FROM part WHERE product_code = 'C100'";
        String deleteSqlController = "DELETE FROM controller WHERE product_code = 'C100'";
        try (Connection conn = MySqlService.getConnection()) {
            // Delete from controller table
            try (PreparedStatement stmtController = conn.prepareStatement(deleteSqlController)) {
                stmtController.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Delete from part table
            try (PreparedStatement stmtPart = conn.prepareStatement(deleteSqlPart)) {
                stmtPart.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Delete from product table
            try (PreparedStatement stmtProduct = conn.prepareStatement(deleteSqlProduct)) {
                stmtProduct.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
