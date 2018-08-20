package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Order;
import com.anatoliivoloshyn.cinemawebapp.entity.User;

import java.util.Date;
import java.util.List;

public interface IDAOOrders {
    List<Order> findAllOrders();
    Order findOrdersById(long id);
    Order addOrder(Order order);
    boolean deleteOrder(Order order);
    boolean updateOrder(Order orderToUpdate, Order updatedOrder);
}
