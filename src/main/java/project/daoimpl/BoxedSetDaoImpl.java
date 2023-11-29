package project.daoimpl;

import project.dao.BoxedSetDao;
import project.dao.ProductDao;
import project.model.product.abstractproduct.BoxedSet;
import project.service.MySqlService;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class BoxedSetDaoImpl implements BoxedSetDao {
    private static final Logger LOGGER = Logger.getLogger(BoxedSetDaoImpl.class.getName());
    private ProductDao productDao;
    
    public BoxedSetDaoImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addBoxedSet(BoxedSet boxedSet) throws SQLException {

    }

    @Override
    public BoxedSet getBoxedSetById(String productCode) throws SQLException {
        return null;
    }

    @Override
    public List<BoxedSet> getAllBoxedSets() throws SQLException {
        return null;
    }

    @Override
    public void deleteBoxedSet(String productCode) throws SQLException {

    }

}

