package project.model.order;
import java.math.BigDecimal;
import java.util.*;

import project.model.product.abstractproduct.*;

public class OrderLine {

	private String productCode;
	private Integer quantity;
	private BigDecimal lineCost;
	private int orderNumber;



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

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * Calculates the total price of this order line.
	 * @return The total price for the quantity of products in this order line.
	 */
	public BigDecimal getTotalPrice() {
		BigDecimal quantityBigDecimal = new BigDecimal(this.quantity);

		return this.lineCost.multiply(quantityBigDecimal);
	}
}