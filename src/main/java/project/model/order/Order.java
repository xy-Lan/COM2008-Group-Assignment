package project.model.order;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import project.model.user.*;

public class Order {

	private int orderNumber;
	private Date date;
	private OrderStatus orderStatus = OrderStatus.PENDING;
	private User user;
    private List<OrderLine> orderLines;

    public Order(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        this.user = user;
    }

	// getter and setter method
	public int getOrderNumber() {
        return orderNumber;
    }

	public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // public void creatOrder() {
    // 	// TODO - implement Order.creatOrder
    // 	throw new UnsupportedOperationException();
    // }

    // public void addOrderLine() {
    // 	// TODO - implement Order.addOrderLine
    // 	throw new UnsupportedOperationException();
    // }

    // public void removeOrderLine() {
    // 	// TODO - implement Order.removeOrderLine
    // 	throw new UnsupportedOperationException();
    // }

    // public void calculateTotal() {
    // 	// TODO - implement Order.calculateTotal
    // 	throw new UnsupportedOperationException();
    // }

    // /**
    //  * Confirms the order.
    //  * If the user who placed the order is not marked as a 'CUSTOMER', they will be after this method is called.
    //  */
    // public void confirmOrder() {
    //     // Implement the order confirmation logic
    //     // ...

    //     // If the user who placed the order is not a 'CUSTOMER', mark them as one
    //     if (!orderedBy.hasRole(Role.CUSTOMER)) {
    //         orderedBy.addRole(Role.CUSTOMER);
    //     }
    // }

    // public void fulfillOrder() {
    // 	if (!orderedBy.hasRole(Role.STAFF)) {
    // 		throw new UnsupportedOperationException("Only staff can fulfill orders.");
    // 	}

    // 	// Implement order fulfilment logic
    // 	//
    // }

//    public static Order createOrderFromCart(Cart cart, User user) {
//        Order order = new Order();
//        order.orderNumber = order.getOrderNumber();
//        order.date = new Date(); // Current date
//        order.orderStatus = OrderStatus.PENDING; // Initial status
//        order.orderedBy = user;
//
//        // Convert Cart items to Order items
//        order.orderItems = cart.getItems().entrySet().stream()
//                .map(entry -> new OrderItem(entry.getKey(), entry.getValue()))
//                .collect(Collectors.toList());
//
//        return order;
//    }



}