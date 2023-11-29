package project.daoImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.WagonDao;
import project.daoimpl.WagonDaoImpl;
import project.model.product.Wagon;
import project.service.MySqlService;

import java.util.List;

public class WagonDaoImplTest {

        private WagonDao wagonDao;

        @BeforeEach
        public void setUp() {
            // 初始化 WagonDao
            wagonDao = new WagonDaoImpl(); // 假设实现类名为 WagonDaoImpl
        }

        @Test
        public void testGetAllWagons() {
            List<Wagon> wagons = wagonDao.getAllWagons();
            Assertions.assertNotNull(wagons, "Wagons list should not be null");
            Assertions.assertFalse(wagons.isEmpty(), "Wagons list should not be empty");

            boolean hasProductCodeSW122 = wagons.stream()
                    .anyMatch(wagon -> "SW122".equals(wagon.getProductCode()));
            Assertions.assertTrue(hasProductCodeSW122, "Wagons list should contain a wagon with productCode 'SW122'");

            boolean hasProductCodeSW123 = wagons.stream()
                    .anyMatch(wagon -> "SW123".equals(wagon.getProductCode()));
            Assertions.assertTrue(hasProductCodeSW123, "Wagons list should contain a wagon with productCode 'SW123'");
        }
}

