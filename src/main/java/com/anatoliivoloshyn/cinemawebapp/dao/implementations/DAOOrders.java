package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOOrders;
import com.anatoliivoloshyn.cinemawebapp.entity.Order;
import com.anatoliivoloshyn.cinemawebapp.entity.User;

import java.util.Date;
import java.util.List;

public class DAOOrders implements IDAOOrders {
    @Override
    public List<Order> findAllOrders() {
        return null;
    }

    @Override
    public List<Order> findOrdersByUser(User user) {
        return null;
    }

    @Override
    public List<Order> findOrdersByDate(Date date) {
        return null;
    }

    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(Order order) {
        return false;
    }

    @Override
    public boolean updateOrder(Order orderToUpdate, Order updatedOrder) {
        return false;
    }
}
