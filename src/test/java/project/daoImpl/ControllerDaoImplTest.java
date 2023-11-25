package project.daoImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.ControllerDao;
import project.daoimpl.ControllerDaoImpl;
import project.model.product.Controller;
import project.service.MysqlService;

import java.util.List;

public class ControllerDaoImplTest {
    private ControllerDao controllerDao;
    private MysqlService mysqlService = new MysqlService();
    @BeforeEach
    public void setUp() {
        // 初始化 ControllerDao
        controllerDao = new ControllerDaoImpl(mysqlService); // 假设实现类名为 ControllerDaoImpl
    }

    @Test
    public void testGetAllControllers() {
        List<Controller> controllers = controllerDao.getAllControllers();
        Assertions.assertNotNull(controllers, "Controllers list should not be null");
        Assertions.assertFalse(controllers.isEmpty(), "Controllers list should not be empty");

        boolean hasProductCodeC122 = controllers.stream()
                .anyMatch(controller -> "C122".equals(controller.getProductCode()));
        Assertions.assertTrue(hasProductCodeC122, "Controllers list should contain a controller with productCode 'C122'");

        boolean hasProductCodeC123 = controllers.stream()
                .anyMatch(controller -> "C123".equals(controller.getProductCode()));
        Assertions.assertTrue(hasProductCodeC123, "Controllers list should contain a controller with productCode 'C123'");
    }
}
