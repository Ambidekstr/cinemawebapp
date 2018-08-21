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
    private Connection connection;
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
        try{
            connection = DataSource.getInstance().getConnection();
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
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return orderList;
    }

    public List<Order> findOrdersByUser(long id) {
        try{
            connection = DataSource.getInstance().getConnection();
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
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return orderList;
    }

    @Override
    public Order addOrder(Order order) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_ORDER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setTimestamp(1,order.getOrdersDateTime());
            preparedStatement.setLong(2,order.getUser().getUserId());
            preparedStatement.execute();
            connection.commit();
            resultSet = preparedStatement.getGeneratedKeys();
            connection.commit();
            resultSet.next();
            order.setOrdersId(resultSet.getLong(1));
        }catch (SQLException e){
            logger.warn("Failed to add order", e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                logger.warn("Failed to rollback", e1);
            }
            return null;
        }finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return order;
    }

    @Override
    public boolean deleteOrder(Order order) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(DELETE_ORDER);
            preparedStatement.setLong(1,order.getOrdersId());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to delete order", e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                logger.warn("Failed to rollback", e1);
            }
            return false;
        }finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return true;
    }

    @Override
    public boolean updateOrder(Order orderToUpdate, Order updatedOrder) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(UPDATE_ORDER);
            preparedStatement.setTimestamp(1,updatedOrder.getOrdersDateTime());
            preparedStatement.setLong(2,updatedOrder.getUser().getUserId());
            preparedStatement.setLong(3,orderToUpdate.getOrdersId());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to update order", e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                logger.warn("Failed to rollback", e1);
            }
            return false;
        }finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return true;
    }
}
