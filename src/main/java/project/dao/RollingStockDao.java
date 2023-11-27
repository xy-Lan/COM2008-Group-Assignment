package project.dao;

import project.model.product.RollingStock;

import java.sql.SQLException;
import java.util.List;

public interface RollingStockDao {
    void addRollingStock(RollingStock rollingStock) throws SQLException;
    RollingStock getRollingStock(String productNumber) throws SQLException;
    List<RollingStock> getAllRollingStock() throws SQLException;
    void updateRollingStock(RollingStock rollingStock) throws SQLException;
    void deleteRollingStockById(int id) throws SQLException;
}
