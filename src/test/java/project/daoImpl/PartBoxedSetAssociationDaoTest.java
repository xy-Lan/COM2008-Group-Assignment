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
    public void testGetAssociation() {

        String partProductCode = "C122"; // 替换为实际的产品代码
        String boxedSetProductCode = "P123"; // 替换为实际的产品代码

        PartBoxedSetAssociation association = partBoxedSetAssociationDao.getAssociation(partProductCode, boxedSetProductCode);

        System.out.println(association.getBoxedSet().getProductCode());
    }

    @Test
    public void testUpdateAssociation() {
        PartBoxedSetAssociationDaoImpl dao = new PartBoxedSetAssociationDaoImpl();

        String partProductCode = "part123";
        String boxedSetProductCode = "set123";
        int originalQuantity = 5;

        Controller controller = controllerDao.getController("C122");
        TrackPack trackPack = trackPackDao.getTrackPack("P123");
        PartBoxedSetAssociation association = new PartBoxedSetAssociation(trackPack,controller , originalQuantity + 1);

        dao.updateAssociation(association);

    }

//    @Test
//    public void testDeleteAssociation() {
//        partBoxedSetAssociationDao.deleteAssociation("C124", "P123");
//
//    }

}
