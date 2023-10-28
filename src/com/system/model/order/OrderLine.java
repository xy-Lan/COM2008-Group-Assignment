package com.system.model.order;
import java.util.*;
import com.system.model.product.abstractproduct.*;

public class OrderLine {

	Product orderedAs;
	private String productCode;
	private Integer quantity;
	private Float lineCost;

	public void calculateLineCost() {
		// TODO - implement OrderLine.calculateLineCost
		throw new UnsupportedOperationException();
	}

}