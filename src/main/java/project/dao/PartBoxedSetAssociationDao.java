package project.dao;

import project.model.product.association.PartBoxedSetAssociation;

import java.sql.SQLException;
import java.util.List;

public interface PartBoxedSetAssociationDao {
    void addAssociation(PartBoxedSetAssociation association);
    PartBoxedSetAssociation getAssociation(String partProductCode, String boxedSetProductCode) ;
    List<PartBoxedSetAssociation> getAssociationsForBoxedSet(String boxedSetProductCode);
    void updateAssociation(PartBoxedSetAssociation association);
    void deleteAssociation(String partProductCode, String boxedSetProductCode) ;
}
