package project.model.product;

import project.model.product.abstractproduct.Part;
import project.model.product.enums.Era;
import project.model.product.enums.Gauge;
import project.model.product.enums.RollingStockType;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RollingStock extends Part {
    private RollingStockType rollingStockType;
    private Era era;

    public RollingStock(String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType, RollingStockType rollingStockType, Era era) {
        super(productCode, brandName, productName, retailPrice, gaugeType);
        this.rollingStockType = rollingStockType;
        this.era = era;
    }

    public RollingStockType getRollingStockType() {
        return rollingStockType;
    }

    public void setRollingStockType(RollingStockType rollingStockType) {
        this.rollingStockType = rollingStockType;
    }

    public Era getEra() {
        return era;
    }

    public void setEra(Era era) {
        this.era = era;
    }

    @Override
    public String getSubclassTableSql() {
        return null;
    }

    @Override
    public void setSubclassTableParameters(PreparedStatement preparedStatement) throws SQLException {

    }
}
