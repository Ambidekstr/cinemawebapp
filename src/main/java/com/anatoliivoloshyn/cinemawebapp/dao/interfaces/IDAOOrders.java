package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Order;
import com.anatoliivoloshyn.cinemawebapp.entity.User;

import java.util.Date;
import java.util.List;

public interface IDAOOrders {
    List<Order> findAllOrders();
<<<<<<< HEAD
    List<Order> findOrdersByUser(User user);
    List<Order> findOrdersByDate(Date date);
=======
    Order findOrdersById(long id);
>>>>>>> bcce36c19e06efe888e479df5ed4c38be5fa5889
    boolean addOrder(Order order);
    boolean deleteOrder(Order order);
    boolean updateOrder(Order orderToUpdate, Order updatedOrder);
}
