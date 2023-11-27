package project.dao;

import project.model.product.association.PartBoxedSetAssociation;

import java.sql.SQLException;
import java.util.List;

public interface PartBoxedSetAssociationDao {
    void addAssociation(PartBoxedSetAssociation association) throws SQLException;
    PartBoxedSetAssociation getAssociation(String partProductCode, String boxedSetProductCode) throws SQLException;
    List<PartBoxedSetAssociation> getAllAssociations() throws SQLException;
    void updateAssociation(PartBoxedSetAssociation association) throws SQLException;
    void deleteAssociation(String partProductCode, String boxedSetProductCode) throws SQLException;
}
