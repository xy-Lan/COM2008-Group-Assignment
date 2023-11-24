package project.model.product;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.product.abstractproduct.*;
import project.model.product.enums.*;

public class Locomotive extends Part {

	private DCCType dccType;
	private Era era;

	public Locomotive(String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType, DCCType dccType, Era era) {
        super(productCode, brandName, productName, retailPrice, gaugeType);
        this.dccType = dccType;
        this.era = era;
    }
    
	// Static method to create a Locomotive instance from a ResultSet
	public static Locomotive fromResultSet(ResultSet resultSet) throws SQLException {
        String productCode = resultSet.getString("product_code");
        String brandName = resultSet.getString("brand_name");
        String productName = resultSet.getString("product_name");
        BigDecimal retailPrice = resultSet.getBigDecimal("retail_price");
        Gauge gaugeType = Gauge.valueOf(resultSet.getString("gauge_type"));
        DCCType dccType = DCCType.valueOf(resultSet.getString("dcc_type"));
        Era era = Era.valueOf(resultSet.getString("era")); 

        return new Locomotive(productCode, brandName, productName, retailPrice, gaugeType, dccType, era);
    }

    public void setProductTableParameters(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, this.getProductCode());
        preparedStatement.setString(2, this.getBrandName());
        preparedStatement.setString(3, this.getProductName());
        preparedStatement.setBigDecimal(4, this.getRetailPrice());
        preparedStatement.setString(5, this.getGaugeType().name());
    }

    public void setLocomotiveTableParameters(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, this.getProductCode());
        preparedStatement.setString(2, this.getDccType().name());
        preparedStatement.setString(3, this.getEra().name());
    }

    public Boolean hasSoundCapability() {
        return this.dccType == DCCType.DCC_SOUND;
	}

    public DCCType getDccType() {
        return dccType;
    }


    public void setDccType(DCCType dccType) {
        this.dccType = dccType;
    }

    public Era getEra() {
        return era;
    }

    public void setEra(Era era) {
        this.era = era;
    }

}