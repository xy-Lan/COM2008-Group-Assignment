package project.dao;

import project.model.product.abstractproduct.BoxedSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BoxedSetDao {
    void addBoxedSet(BoxedSet boxedSet, Connection connection) throws SQLException;
    BoxedSet getBoxedSetById(String productCode) throws SQLException;
    List<BoxedSet> getAllBoxedSets() throws SQLException;
    void deleteBoxedSet(String productCode, Connection connection) throws SQLException;
}
