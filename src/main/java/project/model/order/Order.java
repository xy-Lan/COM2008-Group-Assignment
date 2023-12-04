package project.model.order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import project.model.user.*;

public class Order {

	private int orderNumber;

    private LocalDate localDate = LocalDate.now();
	private Date date = Date.valueOf(localDate);
	private OrderStatus orderStatus = OrderStatus.PENDING;
	private User user;
    private List<OrderLine> orderLines;

    public Order(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        this.user = user;

    }

    public void printDate() {
        System.out.println("Order date: " + date.toString());
    }

    public static Order fromResultSet(ResultSet resultSet, User user) throws SQLException {
        int orderNumber = resultSet.getInt("order_number");
        Date date = resultSet.getDate("date");
        OrderStatus orderStatus = OrderStatus.valueOf(resultSet.getString("order_status"));

        Order order = new Order(user);
        order.setOrderNumber(orderNumber);
        order.setDate(date);
        order.setOrderStatus(orderStatus);

        return order;
    }

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

}