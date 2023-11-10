package main.java.com.system.model.order;
import java.math.BigDecimal;
import java.util.*;
import main.java.com.system.model.product.abstractproduct.*;

public class OrderLine {

	Product orderedAs;
	private String productCode;
	private Integer quantity;
	private BigDecimal lineCost;

	public void calculateLineCost() {
		// TODO - implement OrderLine.calculateLineCost
		throw new UnsupportedOperationException();
	}

}