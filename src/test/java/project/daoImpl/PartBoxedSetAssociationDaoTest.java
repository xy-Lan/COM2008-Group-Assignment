package project.daoImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.ControllerDao;
import project.dao.PartBoxedSetAssociationDao;
import project.dao.TrackPackDao;
import project.daoimpl.ControllerDaoImpl;
import project.daoimpl.PartBoxedSetAssociationDaoImpl;
import project.daoimpl.TrackPackDaoImpl;
import project.model.product.Controller;
import project.model.product.TrackPack;
import project.model.product.association.PartBoxedSetAssociation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PartBoxedSetAssociationDaoTest {
    private PartBoxedSetAssociationDao partBoxedSetAssociationDao = new PartBoxedSetAssociationDaoImpl();
    private ControllerDao controllerDao = new ControllerDaoImpl();
    private TrackPackDao trackPackDao = new TrackPackDaoImpl();
    @BeforeEach
    void setUp() {
        partBoxedSetAssociationDao = new PartBoxedSetAssociationDaoImpl();
    }

//    @Test
//    void addAssociation() {
//        Controller controller = controllerDao.getController("C122");
//
//        TrackPack trackPack = trackPackDao.getTrackPack("P123");
//
//        PartBoxedSetAssociation testAssociation = new PartBoxedSetAssociation(trackPack,controller, 10);
//        partBoxedSetAssociationDao.addAssociation(testAssociation);
//    }

    @Test
    public void testGetAssociationsForBoxedSet() {
        String boxedSetProductCode = "P123";

        // 调用方法
        List<PartBoxedSetAssociation> associations = partBoxedSetAssociationDao.getAssociationsForBoxedSet(boxedSetProductCode);

        // 检查返回的列表不为空，并且至少包含一个关联
        assertNotNull(associations);
        assertFalse(associations.isEmpty());

        // 对列表中的每个关联关系进行进一步验证
        for (PartBoxedSetAssociation association : associations) {
            assertNotNull(association.getPart());
            assertNotNull(association.getBoxedSet());
            assertTrue(association.getQuantity() > 0);
            assertEquals(boxedSetProductCode, association.getBoxedSet().getProductCode());
            // 可以添加更多验证，例如检查part的详细信息
        }
    }


    @Test
    public void testGetAssociation() {

        String partProductCode = "C122";
        String boxedSetProductCode = "P123"; // 替换为实际的产品代码

        PartBoxedSetAssociation association = partBoxedSetAssociationDao.getAssociation(partProductCode, boxedSetProductCode);

        System.out.println(association.getBoxedSet().getProductCode());
    }

//    @Test
//    public void testUpdateAssociation() {
//        PartBoxedSetAssociationDaoImpl dao = new PartBoxedSetAssociationDaoImpl();
//
//        String partProductCode = "part123";
//        String boxedSetProductCode = "set123";
//        int originalQuantity = 5;
//
//        Controller controller = controllerDao.getController("C122");
//        TrackPack trackPack = trackPackDao.getTrackPack("P123");
//        PartBoxedSetAssociation association = new PartBoxedSetAssociation(trackPack,controller , originalQuantity + 1);
//
//        dao.updateAssociation(association);
//
//    }

//    @Test
//    public void testDeleteAssociation() {
//        partBoxedSetAssociationDao.deleteAssociation("C124", "P123");
//
//    }

}
