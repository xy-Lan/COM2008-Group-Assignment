package project.model.order;
import java.math.BigDecimal;
import java.util.*;

import project.model.product.abstractproduct.*;

public class OrderLine {

	private String productCode;
	private Integer quantity;
	private BigDecimal lineCost;
	private String orderNumber;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getLineCost() {
		return lineCost;
	}

	public void setLineCost(BigDecimal lineCost) {
		this.lineCost = lineCost;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

//	public void calculateLineCost() {
//		// TODO - implement OrderLine.calculateLineCost
//		throw new UnsupportedOperationException();
//	}

}