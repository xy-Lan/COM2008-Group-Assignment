package project.daoImpl;

import project.model.order.Order;
import project.model.user.User;

public class TestOrder {
    public static void main(String[] args) {
        Order order = new Order(new User("xy@gmail,com"));
        order.printDate();
    }
}
