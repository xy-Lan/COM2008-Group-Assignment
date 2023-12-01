package project.daoimpl;

import project.dao.PartBoxedSetAssociationDao;
import project.model.product.association.PartBoxedSetAssociation;
import project.service.MySqlService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class PartBoxedSetAssociationDaoImpl implements PartBoxedSetAssociationDao {
    private static final Logger LOGGER = Logger.getLogger(PartBoxedSetAssociationDaoImpl.class.getName());
    @Override
    public void addAssociation(PartBoxedSetAssociation association) {
        String insertSql = "INSERT INTO part_boxed_set_association (part_product_code, boxed_set_product_code, quantity) VALUES (?, ?, ?)";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertSql)) {

            stmt.setString(1, association.getPart().getProductCode());
            stmt.setString(2, association.getBoxedSet().getProductCode());
            stmt.setInt(3, association.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PartBoxedSetAssociation getAssociation(String partProductCode, String boxedSetProductCode) {
        return null;
    }

    @Override
    public List<PartBoxedSetAssociation> getAllAssociations() {
        return null;
    }

    @Override
    public void updateAssociation(PartBoxedSetAssociation association) {

    }

    @Override
    public void deleteAssociation(String partProductCode, String boxedSetProductCode) {

    }
}
