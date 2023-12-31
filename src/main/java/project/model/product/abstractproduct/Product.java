package project.model.product.abstractproduct;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import project.model.order.*;
import project.model.product.enums.Gauge;

public abstract class Product {
	private String productCode;
	private String brandName;
	private String productName;
	private BigDecimal retailPrice;
	private Gauge gaugeType;

	public Product(String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType) {
		this.productCode = productCode;
		this.brandName = brandName;
		this.productName = productName;
		this.retailPrice = retailPrice;
		this.gaugeType = gaugeType;
	}

	public void setProductTableParameters(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, this.getProductCode());
		preparedStatement.setString(2, this.getBrandName());
		preparedStatement.setString(3, this.getProductName());
		preparedStatement.setBigDecimal(4, this.getRetailPrice());
		preparedStatement.setString(5, this.getGaugeType().name());
	}

	public abstract String getSubclassTableSql();
    

	public abstract void setSubclassTableParameters(PreparedStatement preparedStatement) throws SQLException;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBrandName() {return brandName;}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Gauge getGaugeType() {
		return gaugeType;
	}



	public void setGaugeType(Gauge gaugeType) {
		this.gaugeType = gaugeType;
	}

}