package project.model.product;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.product.abstractproduct.*;
import project.model.product.enums.*;

public class Controller extends Part {

	private ControllerType conTrollerType;
	private Boolean isDigital;

	public Controller (String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType, ControllerType conTrollerType, Boolean isDigital) {
        super(productCode, brandName, productName, retailPrice, gaugeType);
        this.conTrollerType = conTrollerType;
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
        Boolean isDigital = resultSet.getBoolean("is_digital"); 

        return new Controller(productCode, brandName, productName, retailPrice, gaugeType, conTrollerType, isDigital);
    }

    @Override
    public String getSubclassTableSql() {
        return "INSERT INTO controller (product_code, controller_type, era, is_digital) VALUES (?, ?, ?, ?)";
    }

    @Override
    public void setSubclassTableParameters(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, this.getProductCode());
        preparedStatement.setString(2, this.conTrollerType.name());
        preparedStatement.setBoolean(3, this.isDigital);
    }

    public ControllerType getControllerType() {
        return conTrollerType;
    }

    public void setControllerType(ControllerType conTrollerType) {
        this.conTrollerType = conTrollerType;
    }


    public Boolean getIsDigital() {
        return isDigital;
    }

    public void setIsDigital(Boolean isDigital) {
        this.isDigital = isDigital;
    }

}