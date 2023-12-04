package project.service;

import project.dao.*;
import project.daoimpl.*;
import project.exceptions.OrderCreationException;
import project.exceptions.StaffOrderException;
import project.model.order.Order;
import project.model.order.OrderLine;
import project.model.order.OrderStatus;
import project.model.product.abstractproduct.Product;
import project.model.user.Role;
import project.model.user.User;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import java.util.Optional;
import java.util.logging.Logger;
import java.util.logging.Level;

public class OrderService {
	private static final Logger logger = Logger.getLogger(OrderService.class.getName());

	private List<Order> orders; // For managing multiple orders
    private OrderDao orderDao = new OrderDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	private ProductDao productDao = new ProductDaoImpl();
	private OrderLineDao orderLineDao = new OrderLineDaoImpl();
	private InventoryDao inventoryDao = new InventoryDaoImpl();
	public OrderService(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	private static final Logger LOGGER = Logger.getLogger(OrderService.class.getName());


	/**
	 * Creates a new order with a specified user. The order is initialized
	 * in a PENDING state and saved to the database. This method includes
	 * exception handling to ensure robustness in database operations.
	 *
	 * @param user The user for whom the order is being created.
	 * @return The newly created order.
	 * @throws RuntimeException if there is an error during order creation.
	 */
	public Order createOrder(User user) {
		// Validate the input user object
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null.");
		}

		try {
			// Create a new order instance
			Order order = new Order(user);
			System.out.println("Insert to database: Create a new order, user id : "+ user.getUserID() + "date" + order.getDate());
			order.setOrderStatus(OrderStatus.PENDING);
			order.setOrderLines(new ArrayList<>()); // Initialize with an empty list of order lines

			// Save the initial order to the database
			orderDao.addOrder(order);

			return order;
		}  catch (RuntimeException e) {
			// Catch other runtime exceptions
			logger.log(Level.SEVERE, "Unexpected error creating order for user: " + user.getUserID(), e);
			throw e;
		}
	}

    public Order addToBasket(int userId, String productCode, int quantity) {
        //Retrieve or create an order
		Optional<Order> existingOrder = orderDao.getPendingOrderByUserId(userId);
		Order order;
		User user = new User(userId);
		if (existingOrder.isPresent()) {
			order = existingOrder.get();
//			System.out.println("Insert to database: Create a new order, user id : "+ user.getUserID() + "date" + order.getDate());
		} else {
			order = createOrder(user);
		}

		OrderLineDao orderLineDao = new OrderLineDaoImpl();
		OrderLine exitingOrderLine = orderLineDao.getOrderLine(order.getOrderNumber(), productCode);
		if (exitingOrderLine == null) {
			//Access to commodity information and costs
			Product product = productDao.getProduct(productCode);
			BigDecimal lineCost = product.getRetailPrice().multiply(new BigDecimal(quantity));

			// Add products to the order
			OrderLine orderLine = new OrderLine(productCode, quantity, lineCost, order.getOrderNumber());
			// Save the OrderLine to the database
			addOrderLine(order.getOrderNumber(), orderLine);
		} else {
			//If the product is already added to the basket, update its quantity
			int previousQuantity = exitingOrderLine.getQuantity();
			exitingOrderLine.setQuantity(quantity + previousQuantity);
			orderLineDao.updateOrderLine(exitingOrderLine);
		}
		return order;
	}

	/**
	 * Adds an order line to an existing order.
	 *
	 * @param orderNumber The order number to which the order line will be added.
	 * @param orderLine The OrderLine object to be added.
	 * @throws IllegalArgumentException if the order specified by orderNumber does not exist.
	 */
	public void addOrderLine(int orderNumber, OrderLine orderLine)  {
		// Retrieve the order by its ID
		Optional<Order> orderOptional = orderDao.getOrderById(orderNumber);
		if (!orderOptional.isPresent()) {
			//Throw a standard exception instead of a custom one
			throw new IllegalArgumentException("Order not found for order number: " + orderNumber);
		}

		// Set the order number on the order line
		orderLine.setOrderNumber(orderNumber);

        //Set the order number on the order line
		orderLineDao.addOrderLine(orderLine);

	}

	public void updateOrderLineQuantity(String productCode, int newQuantity, int orderNumber) {
		// Retrieve the unit price of the product (assuming there's a method getProductPrice returning BigDecimal)
		BigDecimal unitPrice = orderLineDao.getProductRetailPrice(productCode);

		// Calculate the new lineCost
		BigDecimal newLineCost = unitPrice.multiply(new BigDecimal(newQuantity));

		// Create an OrderLine instance with the new quantity and calculated lineCost
		OrderLine updatedOrderLine = new OrderLine(productCode, newQuantity, newLineCost, orderNumber);

		// Call the dao layer method to update the database
		try {
			orderLineDao.updateOrderLine(updatedOrderLine);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unexpected error updating order line: " + e.getMessage(), e);

			throw e;
		}
	}




	/**
	 * Removes an order line from an existing order.
	 *
	 * @param orderNumber The order number from which the order line will be removed.
	 * @param productCode The product code of the order line to be removed.
	 * @throws IllegalArgumentException if the order line specified by orderNumber and productCode is not found.
	 */

	public void removeOrderLine(int orderNumber, String productCode) {
		// Retrieve the order by its ID
		Optional<OrderLine> orderLineOptional = orderDao.findOrderLineByOrderNumberAndProductCode(orderNumber, productCode);

		if (!orderLineOptional.isPresent()) {
			// Throw a standard exception if the order is not found
			throw new IllegalArgumentException("Order line with product code " + productCode + " not found in order " + orderNumber);
		}

		// Remove the order line from the database
		orderLineDao.deleteOrderLine(orderLineOptional.get().getOrderNumber(),orderLineOptional.get().getProductCode());
	}

	/**
	 * Calculates the total cost of the order.
	 *
	 * @param order The order for which the total cost is to be calculated.
	 * @return The total cost of the order.
	 */
	public BigDecimal calculateTotal(Order order) {
		if (order == null) {
			throw new IllegalArgumentException("Order cannot be null.");
		}

		OrderLineDao orderLineDao = new OrderLineDaoImpl();
		List<OrderLine> orderLines = orderLineDao.getAllOrderLines(order.getOrderNumber());
		BigDecimal total = BigDecimal.ZERO;

		for (OrderLine line : orderLines) {
//			System.out.println("Line  " + line.getLineCost());
			BigDecimal lineCost = line.getLineCost();
			if (lineCost != null) {
				total = total.add(lineCost);
			}
		}
//		System.out.println("Finish calculation");
		return total;
	}
    
	/**
     * Confirms the order.
     * If the user who placed the order is not marked as a 'CUSTOMER', they will be after this method is called.
	 * @param order The order to be confirmed.
     */
	public void confirmOrder(Order order) {
		if (order == null) {
			throw new IllegalArgumentException("Order cannot be null.");
		}

		//Set the order status to CONFIRMED.
		order.setOrderStatus(OrderStatus.CONFIRMED);

		// Update order status to database
		orderDao.updateOrderStatus(order);

		// Check and update user roles
		User user = order.getUser();
		int userId = user.getUserID();

		if (user != null && !userDao.hasCustomerRole(userId)) {
			user.addRole(Role.CUSTOMER);
			// Update user information to the database as needed
			userDao.addUserRole(user.getUserID(), Role.CUSTOMER);
		}
    }

	public Boolean fulfillOrder(Order order) throws StaffOrderException {
		if (order.getOrderStatus() == OrderStatus.CONFIRMED) {
			try {
				order.setOrderStatus(OrderStatus.FULFILLED);
				orderDao.updateOrderStatus(order);
				return true;
			} catch (RuntimeException e) {
				LOGGER.log(Level.SEVERE, "Error fulfilling order: " + order.getOrderNumber(), e);
				throw new StaffOrderException("Error fulfilling order: " + order.getOrderNumber(), e);
			}
		} else {
			String message = "Order status is not confirmed. Cannot fulfill order: " + order.getOrderNumber();
			LOGGER.log(Level.WARNING, message);
			throw new StaffOrderException(message);
		}
	}


	public Boolean refuseOrder(Order order) throws StaffOrderException {
		if (order.getOrderStatus() == OrderStatus.CONFIRMED) {
			try {
				order.setOrderStatus(OrderStatus.REFUSED);
				orderDao.updateOrderStatus(order);
				return true;
			} catch (RuntimeException e) {
				LOGGER.log(Level.SEVERE, "Error refusing order: " + order.getOrderNumber(), e);
				throw new StaffOrderException("Error refusing order: " + order.getOrderNumber(), e);
			}
		} else {
			String message = "Order status is not confirmed. Cannot refuse order: " + order.getOrderNumber();
			LOGGER.log(Level.WARNING, message);
			throw new StaffOrderException(message);
		}
	}



}


