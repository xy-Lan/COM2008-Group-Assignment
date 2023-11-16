package project.model.order;

import java.util.Date;

import project.model.user.*;

public class Order {

	private String orderNumber;
	private Date date;
	private OrderStatus orderStatus;
	private User orderedBy;

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
    
	// getter and setter method
	public String getOrderNumber() {
        return orderNumber;
    }

	public void setOrderNumber(String orderNumber) {
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

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(User orderedBy) {
        this.orderedBy = orderedBy;
    }
    

}