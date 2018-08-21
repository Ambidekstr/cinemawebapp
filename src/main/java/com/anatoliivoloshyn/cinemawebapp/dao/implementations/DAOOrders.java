package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOOrders;
import com.anatoliivoloshyn.cinemawebapp.entity.Order;
import com.anatoliivoloshyn.cinemawebapp.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DAOOrders implements IDAOOrders {
    private static Logger logger = Logger.getLogger(DAOOrders.class);
    private final String SELECT_ALL = "Select * from `orders`";
    private final String SELECT_BY_USER = "Select * from `orders` where `user_id` = ?";
    private final String ADD_ORDER = "Insert into `orders`(`orders_date_time`,`user_id`) values (?,?)";
    private final String UPDATE_ORDER = "Update `orders` set `orders_date_time` = ?, `user_id` = ? where `orders_id` = ?";
    private final String DELETE_ORDER = "Delete from `orders` where `orders_id` = ?";
    private List<Order> orderList;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Order orderDao;

    public DAOOrders() {
        orderList = new LinkedList<>();
        orderDao = new Order();
    }

    @Override
    public List<Order> findAllOrders() {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                orderDao = new Order(
                        resultSet.getLong("orders_id"),
                        resultSet.getTimestamp("orders_date_time"),
                        new User(resultSet.getLong("user_id")));
                orderList.add(orderDao);
            }
        }catch (SQLException e){
            logger.warn("Failed to find orders", e);
        }
        return orderList;
    }

    public List<Order> findOrdersByUser(long id) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_BY_USER);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderDao = new Order(
                        resultSet.getLong("orders_id"),
                        resultSet.getTimestamp("orders_date_time"),
                        new User(resultSet.getLong("user_id")));
                orderList.add(orderDao);
            }
        }catch (SQLException e){
            logger.warn("Failed to find orders by user(user id: "+id+")" , e);
        }
        return orderList;
    }

    @Override
    public Order addOrder(Order order) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(ADD_ORDER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setTimestamp(1,order.getOrdersDateTime());
            preparedStatement.setLong(2,order.getUser().getUserId());
            preparedStatement.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            order.setOrdersId(resultSet.getLong(1));
        }catch (SQLException e){
            logger.warn("Failed to add order", e);
            return null;
        }
        return order;
    }

    @Override
    public boolean deleteOrder(Order order) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(DELETE_ORDER);
            preparedStatement.setLong(1,order.getOrdersId());
            preparedStatement.execute();
        }catch (SQLException e){
            logger.warn("Failed to delete order", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateOrder(Order orderToUpdate, Order updatedOrder) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(UPDATE_ORDER);
            preparedStatement.setTimestamp(1,updatedOrder.getOrdersDateTime());
            preparedStatement.setLong(2,updatedOrder.getUser().getUserId());
            preparedStatement.setLong(3,orderToUpdate.getOrdersId());
            preparedStatement.execute();
        }catch (SQLException e){
            logger.warn("Failed to update order", e);
            return false;
        }
        return true;
    }
}
