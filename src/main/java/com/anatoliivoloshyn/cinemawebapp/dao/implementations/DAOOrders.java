package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOOrders;
import com.anatoliivoloshyn.cinemawebapp.entity.Order;
import com.anatoliivoloshyn.cinemawebapp.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOOrders implements IDAOOrders {
    private final String SELECT_ALL = "Select * from `orders`";
    private final String SELECT_BY_ID = "Select * from `orders` where `orders_id` = ?";
    private final String ADD_ORDER = "Insert into `orders`(`orders_date_time`,`user_id`) values (?,?)";
    private final String UPDATE_ORDER = "Update `orders` set `orders_date_time` = ?, `user_id` = ? where `orders_id` = ?";
    private final String DELETE_ORDER = "Delete from `orders` where `orders_id` = ?";
    private List<Order> orderList;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Order orderDao;

    @Override
    public List<Order> findAllOrders() {
        orderList = new LinkedList<>();
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
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
<<<<<<< HEAD
    public List<Order> findOrdersByDate(Date date) {
        return null;
=======
    public Order findOrdersById(long id) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            orderDao = new Order(
                    resultSet.getLong("orders_id"),
                    resultSet.getTimestamp("orders_date_time"),
                    new User(resultSet.getLong("user_id")));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return orderDao;
>>>>>>> bcce36c19e06efe888e479df5ed4c38be5fa5889
    }

    @Override
    public boolean addOrder(Order order) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(ADD_ORDER);
            preparedStatement.setTimestamp(1,order.getOrdersDateTime());
            preparedStatement.setLong(2,order.getUser().getUserId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteOrder(Order order) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(DELETE_ORDER);
            preparedStatement.setLong(1,order.getOrdersId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
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
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
