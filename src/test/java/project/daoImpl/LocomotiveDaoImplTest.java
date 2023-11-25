package project.daoImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.LocomotiveDao;
import project.daoimpl.LocomotiveDaoImpl;
import project.model.product.Locomotive;
import project.service.MysqlService;

import java.util.List;

public class LocomotiveDaoImplTest {
    private LocomotiveDao locomotiveDao;
    private MysqlService mysqlService = new MysqlService();

    @BeforeEach
    public void setUp() {
        // 初始化 LocomotiveDao
        locomotiveDao = new LocomotiveDaoImpl(mysqlService);
    }

    @Test
    public void testGetAllLocomotives() {
        List<Locomotive> locomotives = locomotiveDao.getAllLocomotives();
        Assertions.assertNotNull(locomotives, "Locomotives list should not be null");
        Assertions.assertFalse(locomotives.isEmpty(), "Locomotives list should not be empty");

        boolean hasProductCodeL122 = locomotives.stream()
                .anyMatch(locomotive -> "L122".equals(locomotive.getProductCode()));
        Assertions.assertTrue(hasProductCodeL122, "Locomotives list should contain a locomotive with productCode 'L122'");

        boolean hasProductCodeL123 = locomotives.stream()
                .anyMatch(locomotive -> "L123".equals(locomotive.getProductCode()));
        Assertions.assertTrue(hasProductCodeL123, "Locomotives list should contain a locomotive with productCode 'L123'");
    }
}
