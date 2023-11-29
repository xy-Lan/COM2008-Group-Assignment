package project.daoimpl;

import project.dao.PartDao;
import project.model.product.abstractproduct.Part;
import project.service.MySqlService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartDaoImpl implements PartDao {
    private static final Logger LOGGER = Logger.getLogger(PartDaoImpl.class.getName());

    @Override
    public void addPart(Part part, Connection conn) throws SQLException {
        String sql = "INSERT INTO part (product_code) VALUES (?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            System.out.println(part.getProductCode());
            stmt.setString(1, part.getProductCode());

            int affectedRows = stmt.executeUpdate();
            System.out.println(affectedRows);
            if (affectedRows == 0) {
                throw new SQLException("Creating part failed, no rows affected.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding part to the database", e);
            throw new RuntimeException("Database operation failed", e);
        }
    }


    @Override
    public Part getPartByProductCode(String productCode) throws SQLException {
        return null;
    }

    @Override
    public List<Part> getAllParts() throws SQLException {
        return null;
    }

    @Override
    public void updatePart(Part part) throws SQLException {

    }

    @Override
    public void deletePart(String productCode) throws SQLException {

    }
}
