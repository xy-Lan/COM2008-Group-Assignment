package project.model.product.abstractproduct;
import java.math.BigDecimal;
import java.util.*;

import project.model.order.*;
import project.model.product.enums.Gauge;

public abstract class Product {
	private String productCode;
	private String brandName;
	private String productName;
	private BigDecimal retailPrice;
	private Gauge gaugeType;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBrandName() {
		return brandName;
	}

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