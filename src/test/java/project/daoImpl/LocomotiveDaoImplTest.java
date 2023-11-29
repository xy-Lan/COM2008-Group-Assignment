package project.daoImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.LocomotiveDao;
import project.dao.PartDao;
import project.dao.ProductDao;
import project.daoimpl.LocomotiveDaoImpl;
import project.daoimpl.ProductDaoImpl;
import project.model.product.Locomotive;
import project.model.product.enums.DCCType;
import project.model.product.enums.Era;
import project.model.product.enums.Gauge;
import project.service.MySqlService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LocomotiveDaoImplTest {
    private LocomotiveDao locomotiveDao;
    private ProductDao productDao;

    @BeforeEach
    public void setUp() {
        locomotiveDao = new LocomotiveDaoImpl();
        productDao = new ProductDaoImpl();
    }

    @Test
    public void testAddLocomotive() {
        // 创建一个 Locomotive 对象
        String productCode = "test_code";
        String brandName = "Test Brand";
        String productName = "Test Product";
        BigDecimal retailPrice = new BigDecimal("100.00");
        Gauge gaugeType = Gauge.OO_GAUGE; // 示例规格类型
        DCCType dccType = DCCType.DCC_FITTED; // 示例 DCC 类型
        Era era = Era.ERA_3; // 示例时代

        Locomotive locomotive = new Locomotive(productCode, brandName, productName, retailPrice, gaugeType, dccType, era);


        assertDoesNotThrow(() -> locomotiveDao.addLocomotive(locomotive));

    }
//
//    @Test
//    public void testGetAllLocomotives() {
//        List<Locomotive> locomotives = locomotiveDao.getAllLocomotives();
//        Assertions.assertNotNull(locomotives, "Locomotives list should not be null");
//        Assertions.assertFalse(locomotives.isEmpty(), "Locomotives list should not be empty");
//
//        boolean hasProductCodeL122 = locomotives.stream()
//                .anyMatch(locomotive -> "L122".equals(locomotive.getProductCode()));
//        Assertions.assertTrue(hasProductCodeL122, "Locomotives list should contain a locomotive with productCode 'L122'");
//
//        boolean hasProductCodeL123 = locomotives.stream()
//                .anyMatch(locomotive -> "L123".equals(locomotive.getProductCode()));
//        Assertions.assertTrue(hasProductCodeL123, "Locomotives list should contain a locomotive with productCode 'L123'");
//    }

    @AfterEach
    public void tearDown() {
        String deleteSqlProduct = "DELETE FROM product WHERE product_code = 'test_code'";
        String deleteSqlPart = "DELETE FROM part WHERE product_code = 'test_code'";
        String deleteSqlLocomotive = "DELETE FROM locomotive WHERE product_code = 'test_code'";

        try (Connection conn = MySqlService.getConnection()) {
            // Delete from locomotive table
            try (PreparedStatement stmtLocomotive = conn.prepareStatement(deleteSqlLocomotive)) {
                stmtLocomotive.executeUpdate();
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
