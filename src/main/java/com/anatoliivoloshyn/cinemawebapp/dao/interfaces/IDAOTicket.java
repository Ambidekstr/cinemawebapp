package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;

import java.util.List;

public interface IDAOTicket {
    List<Ticket> findAllTickets();
    List<Ticket> findAllTicketsBySession(Session session);
    Ticket findTicketById(long id);
    boolean addTicket(Ticket ticket);
    boolean updateTicket(Ticket ticketToUpdate, Ticket updatedTicket);
    boolean deleteTicket(Ticket ticket);
}
