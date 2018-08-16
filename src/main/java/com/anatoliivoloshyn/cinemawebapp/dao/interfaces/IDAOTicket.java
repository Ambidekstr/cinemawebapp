package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;
import com.anatoliivoloshyn.cinemawebapp.entity.User;

import java.util.List;

public interface IDAOTicket {
    List<Ticket> findAllTickets();
    Ticket findTicketById(long id);
    boolean addTicket(Ticket ticket);
    boolean updateTicket(Ticket ticketToUpdate, Ticket updatedTicket);
    boolean deleteTicket(Ticket ticket);
}
