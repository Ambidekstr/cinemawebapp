package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Order;
import com.anatoliivoloshyn.cinemawebapp.entity.User;

import java.util.Date;
import java.util.List;
/**
 * The interface that allows you to work with Orders table in the data base.
 */
public interface IDAOOrders {
    /**
     * Method that finds all Orders in data base.
     * @return List of Orders if empty than there is no Orders in the data base.
     */
    List<Order> findAllOrders();
    /**
     * Method that finds all Orders that correspond to User id.
     * @param id User id.
     * @return List of Orders if empty than there is no Orders from this User.
     */
    List<Order> findOrdersByUser(long id);
    /**
     * Method that add a new Order to the data base.
     * @param order Order that you want to add.
     * @return True if Order is added successfully and false if not.
     */
    Order addOrder(Order order);
    /**
     * Method that deletes an existing Order from the data base.
     * @param order Order that you want to delete.
     * @return True if Order is deleted successfully and false if not.
     */
    boolean deleteOrder(Order order);
    /**
     * Method that updates an existing Order in the data base.
     * @param updatedOrder Updated order.
     * @return True if Order is updated successfully and false if not.
     */
    boolean updateOrder(Order updatedOrder);
}
