package com.system.model.product.abstractproduct;
import com.system.model.order.*;
import java.util.*;

public abstract class Product {

	Collection<OrderLine> containsProduct;
	private String productCode;
	private String brandName;
	private String productName;
	private Float retailPrice;

}