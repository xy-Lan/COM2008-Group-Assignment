package project.model.order;
import java.math.BigDecimal;
import java.util.*;

import project.model.product.abstractproduct.*;

public class OrderLine {

	private String productCode;
	private Integer quantity;
	private BigDecimal lineCost;
	private int orderNumber;

<<<<<<< HEAD
	public OrderLine(String productCode, Integer quantity, BigDecimal lineCost, int orderNumber) {
		this.productCode = productCode;
		this.quantity = quantity;
		this.lineCost = lineCost;
		this.orderNumber = orderNumber;

	}
=======

>>>>>>> fa1fed46745d879d62a77a25155a4c6ab8b8a9fc

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