package project.daoImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.ControllerDao;
import project.daoimpl.ControllerDaoImpl;
import project.daoimpl.PartDaoImpl;
import project.model.product.Controller;
import project.model.product.enums.ControllerType;
import project.model.product.enums.Gauge;
import project.service.MysqlService;

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
    private MysqlService mysqlService = new MysqlService();
    private static final Logger LOGGER = Logger.getLogger(ControllerDaoImplTest.class.getName());
    @BeforeEach
    public void setUp() {
        controllerDao = new ControllerDaoImpl(mysqlService);
    }

    @Test
    void testAddController() {
        Controller testController = new Controller("C100", "testBrand", "testName", new BigDecimal("99.99"), Gauge.TT_GAUGE, ControllerType.STANDARD_CONTROLLER, true);

        assertDoesNotThrow(() -> controllerDao.addController(testController));

    }

    @Test
    void testGetController() {
        String testProductCode = "C122";// 使用实际的测试代码
//        Controller testController = new Controller("testCode2", "testBrand", "testName", new BigDecimal("99.99");
        Controller controller = controllerDao.getController(testProductCode);

        assertNotNull(controller);
        assertEquals(testProductCode, controller.getProductCode());
        // 进行更多的断言来验证其他属性
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
        try (Connection conn = mysqlService.getConnection()) {
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
