package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Order;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;

import java.util.List;

public interface IDAOTicket {
    List<Ticket> findAllTickets();
    List<Ticket> findAllTicketsBySession(Session session);
    List<Ticket> findAllTicketsByOrder(Order order);
    Ticket findTicketById(long id);
    boolean addTicket(Ticket... tickets);
    boolean updateTicket(Ticket updatedTicket);
    boolean deleteTicket(Ticket ticket);
}
