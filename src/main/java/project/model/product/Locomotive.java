package project.model.product;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.product.abstractproduct.*;
import project.model.product.enums.*;

public class Locomotive extends Part {

	private DCCType dccCode;
	private Era era;

	public Locomotive(String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType, DCCType dccCode, Era era) {
        super(productCode, brandName, productName, retailPrice, gaugeType);
        this.dccCode = dccCode;
        this.era = era;
    }
    
	// Static method to create a Locomotive instance from a ResultSet
	public static Locomotive fromResultSet(ResultSet resultSet) throws SQLException {
        String productCode = resultSet.getString("product_code");
        String brandName = resultSet.getString("brand_name");
        String productName = resultSet.getString("product_name");
        BigDecimal retailPrice = resultSet.getBigDecimal("retail_price");
        Gauge gaugeType = Gauge.valueOf(resultSet.getString("gauge_type"));
        DCCType dccCode = DCCType.valueOf(resultSet.getString("dcc_code")); 
        Era era = Era.valueOf(resultSet.getString("era")); 

        return new Locomotive(productCode, brandName, productName, retailPrice, gaugeType, dccCode, era);
    }

	public Boolean canBeDigitallyController() {
		// TODO - implement Locomotive.canBeDigitallyController
		throw new UnsupportedOperationException();
	}

	public Boolean hasSoundCapability() {
		// TODO - implement Locomotive.hasSoundCapability
		throw new UnsupportedOperationException();
	}

}