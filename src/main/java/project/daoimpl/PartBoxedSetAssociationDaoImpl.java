package project.daoimpl;

import project.dao.PartBoxedSetAssociationDao;
import project.model.product.abstractproduct.BoxedSet;
import project.model.product.abstractproduct.Part;
import project.model.product.association.PartBoxedSetAssociation;
import project.service.MySqlService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
        String sql = "SELECT * FROM part_boxed_set_association WHERE part_product_code = ? AND boxed_set_product_code = ?";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, partProductCode);
            stmt.setString(2, boxedSetProductCode);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int quantity = rs.getInt("quantity");

                    Part part = getPartByProductCode(partProductCode);
                    BoxedSet boxedSet = getBoxedSetByProductCode(boxedSetProductCode);

                    return new PartBoxedSetAssociation(boxedSet, part, quantity);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving association", e);
            throw new RuntimeException("Database operation failed", e);
        }
        return null;
    }

    @Override
    public List<PartBoxedSetAssociation> getAssociationsForBoxedSet(String boxedSetProductCode) {
        List<PartBoxedSetAssociation> associations = new ArrayList<>();
        String sql = "SELECT * FROM part_boxed_set_association WHERE boxed_set_product_code = ?";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, boxedSetProductCode);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String partProductCode = rs.getString("part_product_code");
                    int quantity = rs.getInt("quantity");

                    Part part = getPartByProductCode(partProductCode, conn);
                    BoxedSet boxedSet = getBoxedSetByProductCode(boxedSetProductCode, conn);

                    associations.add(new PartBoxedSetAssociation(boxedSet, part, quantity));

                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving associations for boxed set: " + boxedSetProductCode, e);
            throw new RuntimeException("Database operation failed", e);
        }
        return associations;
    }


    private Part getPartByProductCode(String productCode) {MySqlService mySqlService = new MySqlService();
        try (Connection conn = mySqlService.getInstanceConnection()) {
            char firstChar = productCode.charAt(0);
            switch (firstChar) {
                case 'R':
                    return new TrackDaoImpl().getTrack(productCode);
                case 'C':
                    return new ControllerDaoImpl().getController(productCode);
                case 'L':
                    return new LocomotiveDaoImpl().getLocomotive(productCode);
                case 'S':
                    return new RollingStockDaoImpl().getRollingStock(productCode);
                default:
                    return null;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving part with productCode: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    private Part getPartByProductCode(String productCode, Connection conn) throws SQLException {
        boolean createdNewConnection = false;
        if (conn == null) {
            conn = MySqlService.getConnection();
            System.out.println("for part new conn has been created");
            createdNewConnection = true;
        }

        try {
            char firstChar = productCode.charAt(0);
            switch (firstChar) {
                case 'R':
                    return new TrackDaoImpl().getTrack(productCode);
                case 'C':
                    return new ControllerDaoImpl().getController(productCode);
                case 'L':
                    return new LocomotiveDaoImpl().getLocomotive(productCode);
                case 'S':
                    return new RollingStockDaoImpl().getRollingStock(productCode);
                default:
                    return null;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving part with productCode: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (createdNewConnection && conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Error closing connection", e);
                }
            }
        }
    }

    private BoxedSet getBoxedSetByProductCode(String productCode, Connection conn) throws SQLException {
        boolean createdNewConnection = false;
        if (conn == null) {
            conn = MySqlService.getConnection();
            createdNewConnection = true;
        }

        try {
            char firstChar = productCode.charAt(0);
            switch (firstChar) {
                case 'M':
                    return new TrainSetDaoImpl().getTrainSet(productCode);
                case 'P':
                    return new TrackPackDaoImpl().getTrackPack(productCode);
                default:
                    return null;
            }
        } finally {
            if (createdNewConnection && conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Error closing connection", e);
                }
            }
        }
    }


    private BoxedSet getBoxedSetByProductCode(String productCode) {
        MySqlService mySqlService = new MySqlService();
        try (Connection conn = mySqlService.getInstanceConnection()) {
            char firstChar = productCode.charAt(0);
            switch (firstChar) {
                case 'M':
                    return new TrainSetDaoImpl().getTrainSet(productCode);
                case 'P':
                    return new TrackPackDaoImpl().getTrackPack(productCode);
                default:
                    return null;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving boxed set with productCode: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        }
    }


//    private BoxedSet getBoxedSetByProductCode(String productCode, Connection conn) {
//        boolean shouldCloseConnection = false;
//        if (conn == null) {
//            conn = MySqlService.getConnection();
//            shouldCloseConnection = true;
//        }
//        try {
//            char firstChar = productCode.charAt(0);
//            switch (firstChar) {
//                case 'M':
//                    return new TrainSetDaoImpl().getTrainSet(productCode);
//                case 'P':
//                    return new TrackPackDaoImpl().getTrackPack(productCode);
//                default:
//                    return null;
//            }
//        } finally {
//            if (shouldCloseConnection && conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    LOGGER.log(Level.SEVERE, "Error closing connection", e);
//                }
//            }
//        }
//    }


    @Override
    public void updateAssociation(PartBoxedSetAssociation association) {
        String updateSql = "UPDATE part_boxed_set_association SET quantity = ? WHERE part_product_code = ? AND boxed_set_product_code = ?";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(updateSql)) {

            stmt.setInt(1, association.getQuantity());
            stmt.setString(2, association.getPart().getProductCode());
            stmt.setString(3, association.getBoxedSet().getProductCode());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                LOGGER.log(Level.WARNING, "No association updated for part product code: " + association.getPart().getProductCode() + " and boxed set product code: " + association.getBoxedSet().getProductCode());
                throw new RuntimeException("Updating association failed, no rows affected.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error occurred while updating association: " + e.getMessage(), e);
            throw new RuntimeException("Error updating association", e);
        }
    }

    @Override
    public void deleteAssociation(String partProductCode, String boxedSetProductCode) {
        String sql = "DELETE FROM part_boxed_set_association WHERE part_product_code = ? AND boxed_set_product_code = ?";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, partProductCode);
            stmt.setString(2, boxedSetProductCode);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                LOGGER.log(Level.WARNING, "No association found for part product code: " + partProductCode + " and boxed set product code: " + boxedSetProductCode);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error occurred while deleting association: " + e.getMessage(), e);
            throw new RuntimeException("Error deleting association from the database", e);
        }
    }

}
