package project.service;

import project.dao.OrderDao;
import project.model.order.Order;
import project.model.order.OrderStatus;
import project.model.user.Role;
import project.model.user.User;

import java.util.List;
import java.util.ArrayList;

public class OrderService {
    private List<Order> orders; // For managing multiple orders

    private OrderDao orderDao;

    public OrderService() {
        this.orders = new ArrayList<>();
    }
    
     // Additional parameters may be required
    public void creatOrder() {
		// TODO - implement Order.creatOrder
        // Creating New Order Logic
		throw new UnsupportedOperationException();
	}
    
     // Additional parameters may be required
	public void addOrderLine() {
		// TODO - implement Order.addOrderLine
        // Logic for adding order lines to specific orders
		throw new UnsupportedOperationException();
	}
    
    // Additional parameters may be required
	public void removeOrderLine() {
		// TODO - implement Order.removeOrderLine
        // Logic for removing order lines from specific orders
		throw new UnsupportedOperationException();
	}
    
    // Additional parameters may be required
	public void calculateTotal() {
		// TODO - implement Order.calculateTotal
        // Logic for calculating specific order totals
		throw new UnsupportedOperationException();
	}
    
	/**
     * Confirms the order.
     * If the user who placed the order is not marked as a 'CUSTOMER', they will be after this method is called.
     */
	public void confirmOrder(Order order) {
        // Implement the order confirmation logic
        // ...

        // If the user who placed the order is not a 'CUSTOMER', mark them as one
        if (!order.getOrderedBy().hasRole(Role.CUSTOMER)) {
            order.getOrderedBy().addRole(Role.CUSTOMER);
        }
    }

	public void fulfillOrder(Order order) {
		if (!order.getOrderedBy().hasRole(Role.STAFF)) {
			throw new UnsupportedOperationException("Only staff can fulfill orders.");
		}

		// Implement order fulfilment logic
		//
	}

    // Additional methods as needed...
}
