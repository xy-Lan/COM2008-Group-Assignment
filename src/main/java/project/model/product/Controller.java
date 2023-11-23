package project.model.product;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.product.abstractproduct.*;
import project.model.product.enums.*;

public class Controller extends Part {

	private ControllerType conTrollerType;
	private Era era;
	private Boolean isDigital;

	public Controller (String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType, ControllerType conTrollerType, Era era, Boolean isDigital) {
        super(productCode, brandName, productName, retailPrice, gaugeType);
        this.conTrollerType = conTrollerType;
        this.era = era;
		this.isDigital = isDigital;
    }

	// Static method to create a Controller instance from a ResultSet
    public static Controller fromResultSet(ResultSet resultSet) throws SQLException {
        String productCode = resultSet.getString("product_code");
        String brandName = resultSet.getString("brand_name");
        String productName = resultSet.getString("product_name");
        BigDecimal retailPrice = resultSet.getBigDecimal("retail_price");
        Gauge gaugeType = Gauge.valueOf(resultSet.getString("gauge_type")); 
        ControllerType conTrollerType = ControllerType.valueOf(resultSet.getString("controller_type")); 
        Era era = Era.valueOf(resultSet.getString("era")); 
        Boolean isDigital = resultSet.getBoolean("is_digital"); 

        return new Controller(productCode, brandName, productName, retailPrice, gaugeType, conTrollerType, era, isDigital);
    }

}