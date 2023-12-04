package project.daoimpl;

import java.util.ArrayList;
import java.util.List;

import project.dao.OrderDao;
import project.dao.UserDao;
import project.model.order.Order;
import project.model.order.OrderLine;
import project.model.user.User;
import project.service.MySqlService;

import javax.swing.text.html.Option;
import java.sql.*;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.logging.Level;

public class OrderDaoImpl implements OrderDao{
    /**
     * LOGGER is used for logging messages and exceptions in the OrderDaoImpl class.
     * It provides a way to log important information and errors, which is essential for debugging and monitoring.
     * The log's name is based on the class name, which helps in identifying the source of log messages.
     */
    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class.getName());

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void addOrder(Order order) {
        String query = "INSERT INTO orders (user_id, date, order_status) VALUES (?, ?, ?);";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, order.getUser().getUserID()); 
            System.out.println("userId: " + order.getUser().getUserID());
            preparedStatement.setDate(2, order.getDate());
            System.out.println("date: " + order.getDate());
            preparedStatement.setString(3, order.getOrderStatus().toString());
            System.out.println("orderStatus: " + order.getOrderStatus().toString());

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Affected Rows: " + affectedRows);

            if (affectedRows == 0) {
                throw new RuntimeException("Creating order failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    order.setOrderNumber(generatedKeys.getInt(1));
                } else {
                    throw new RuntimeException("Creating order failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "AddOrder method:Database operation failed", e);
            throw new RuntimeException("Error accessing the database", e);
        }
    }

    @Override
    public Optional<Order> getOrderById(int orderNumber) {
        String query = "SELECT * FROM orders WHERE order_number = ?";
;        try (Connection connection = MySqlService.getConnection() ;          PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, orderNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                int userID = resultSet.getInt("user_id");

                Optional<User> user = userDao.getUserById(userID);
                
                /*Create a new Order object containing the User object obtained from userDao (if it exists), otherwise
                 an IllegalArgumentException will be thrown*/
                Order order = Order.fromResultSet(resultSet, user.orElseThrow(() -> new IllegalArgumentException("User not found")));

                return Optional.of(order);
            }
        } catch (SQLException e) {
           //  Handling or logging exceptions
            LOGGER.log(Level.SEVERE, "getOrderById method:Database operation failed", e);
            throw new RuntimeException("Error accessing the database", e);
        }
        return Optional.empty();

    }

    @Override
    public Optional<Order> getPendingOrderByUserId(int userId) {
        String sql = "SELECT * FROM orders WHERE user_id = ? AND order_status = 'PENDING'";
        try (Connection conn = MySqlService.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User(userId);
                    Order order = Order.fromResultSet(rs,user);

                    return Optional.of(order);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "getPendingOrderByUserId method:Database operation failed", e);
            throw new RuntimeException("Error accessing the database", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT o.*, u.* FROM orders o INNER JOIN users u ON o.user_id = u.user_id WHERE o.order_status <> 'PENDING'";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int userID = resultSet.getInt("user_id");
                User user = new User(userID);
                Order order = Order.fromResultSet(resultSet, user);
                orders.add(order);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all orders", e);
            throw  new RuntimeException("Error accessing the database", e);
        }

        return orders;
    }

    @Override
    public void updateOrderStatus(Order order) {
        String sql = "UPDATE orders SET order_status = ? WHERE order_number = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, order.getOrderStatus().toString());
            preparedStatement.setInt(2, order.getOrderNumber());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Updating order failed, no rows affected.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating order status in database", e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public void deleteOrder(int orderNumber) {
        String query = "DELETE FROM orders WHERE order_number = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, orderNumber);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {

                LOGGER.log(Level.WARNING, "No order found with orderId: " + orderNumber);
            } else {
                LOGGER.log(Level.INFO, "Order deleted successfully: " + orderNumber);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting order with orderId: " + orderNumber, e);
            throw  new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT o.*, u.* FROM orders o INNER JOIN users u ON o.user_id = u.user_id WHERE u.user_id = ? AND o.order_status <> 'PENDING'";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = User.fromResultSet(resultSet);
                Order order = Order.fromResultSet(resultSet, user);
                orders.add(order);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving orders for userId: " + userId, e);
            throw  new RuntimeException("Database operation failed", e);
        }

        return orders;
    }

    @Override
    public List<Order> getConfirmedOrder() {
        List<Order> confirmedOrders = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE order_status = 'CONFIRMED'";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                User user = new User(userId);

                Order order = Order.fromResultSet(resultSet, user);

                confirmedOrders.add(order);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving confirmed orders", e);
            throw new RuntimeException("Database operation failed", e);
        }

        return confirmedOrders;
    }


    @Override
    public Boolean hasOrderedBefore(int userId) {
        String query = "SELECT COUNT(*) FROM orders WHERE user_id = ? AND order_status <> 'PENDING'";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error checking if user has ordered before", e);
            throw new RuntimeException("Database operation failed", e);
        }

        return false;
    }



    @Override
    public void addOrderLine(OrderLine orderLine) {
        String sql = "INSERT INTO order_lines (order_number, product_code, quantity, line_cost) VALUES (?, ?, ?, ?)";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, orderLine.getOrderNumber());
            pstmt.setString(2, orderLine.getProductCode());
            pstmt.setInt(3, orderLine.getQuantity());
            pstmt.setBigDecimal(4, orderLine.getLineCost());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding order line to database", e);

            throw new RuntimeException("Error adding order line to database", e);
        }
    }

    @Override
    public void deleteOrderLine(OrderLine orderLine) {
        String sql = "DELETE FROM order_lines WHERE order_number = ? AND product_code = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, orderLine.getOrderNumber());
            pstmt.setString(2, orderLine.getProductCode());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Order line deletion failed, no rows affected.");
            }
        } catch (SQLException e) {

            LOGGER.log(Level.SEVERE, "Error deleting order line to database", e);

            throw new RuntimeException("Error deleting order line from database", e);
        }
    }

    @Override
    public Optional<OrderLine> findOrderLineByOrderNumberAndProductCode(int orderNumber, String productCode) {
        String sql = "SELECT * FROM order_lines WHERE order_number = ? AND product_code = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, orderNumber);
            preparedStatement.setString(2, productCode);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    OrderLine orderLine = new OrderLine();

                    populateOrderLineFromResultSet(orderLine, resultSet);
                    return Optional.of(orderLine);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error finding order line in database", e);
        }

        return Optional.empty();
    }

    private void populateOrderLineFromResultSet(OrderLine orderLine, ResultSet resultSet) throws SQLException {

        orderLine.setOrderNumber(resultSet.getInt("order_number"));
        orderLine.setProductCode(resultSet.getString("product_code"));
        orderLine.setQuantity(resultSet.getInt("quantity"));
        orderLine.setLineCost(resultSet.getBigDecimal("line_cost"));
    }



}
