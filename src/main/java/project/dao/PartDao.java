package project.dao;

import project.model.product.abstractproduct.Part;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PartDao {
    void addPart(Part part, Connection connection) throws SQLException;
    Part getPartByProductCode(String productCode) throws SQLException;
    List<Part> getAllParts() throws SQLException;
    void updatePart(Part part) throws SQLException;
    void deletePart(String productCode, Connection connection) throws SQLException;
}
