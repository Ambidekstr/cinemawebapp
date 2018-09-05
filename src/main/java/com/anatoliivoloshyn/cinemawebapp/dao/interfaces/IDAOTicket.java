package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Order;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;

import java.util.List;
/**
 * The interface that allows you to work with Ticket table in the data base.
 */
public interface IDAOTicket {
    /**
     * Method that finds all Tickets in data base.
     * @return List of Tickets if empty than there is no Tickets in the data base.
     */
    List<Ticket> findAllTickets();
    /**
     * Method that finds all Tickets that correspond to this Session.
     * @param session
     * @return List of Tickets if empty than there is no Tickets that correspond to this Session.
     */
    List<Ticket> findAllTicketsBySession(Session session);
    /**
     * Method that finds all Tickets that correspond to the Order.
     * @param order
     * @return List of Tickets if empty than there is no Tickets that correspond to the Order.
     */
    List<Ticket> findAllTicketsByOrder(Order order);
    /**
     * Method that finds Ticket that correspond to Ticket id.
     * @param id Ticket id.
     * @return Ticket if null than there is no such Ticket.
     */
    Ticket findTicketById(long id);
    /**
     * Method that adds new Tickets to the data base.
     * @param tickets Tickets that you want to add.
     * @return True if Tickets were added successfully and false if not.
     */
    boolean addTicket(Ticket... tickets);
    /**
     * Method that updates an existing Ticket in the data base.
     * @param updatedTicket Updated Ticket.
     * @return True if Ticket is updated successfully and false if not.
     */
    boolean updateTicket(Ticket updatedTicket);
    /**
     * Method that deletes an existing Tickets from the data base.
     * @param tickets Tickets that you want to delete.
     * @return True if Tickets were deleted successfully and false if not.
     */
    boolean deleteTicket(Ticket... tickets);
}
