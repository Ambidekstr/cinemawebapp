package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOTicket;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;
import com.anatoliivoloshyn.cinemawebapp.entity.User;

import java.util.List;

public class DAOTicket implements IDAOTicket {
    @Override
    public List<Ticket> findAllTickets() {
        return null;
    }

    @Override
    public List<Ticket> findAllAvailableTickets() {
        return null;
    }

    @Override
    public List<Ticket> findTicketsByUser(User user) {
        return null;
    }

    @Override
    public List<Ticket> findAllUnavailableTickests() {
        return null;
    }

    @Override
    public List<Ticket> findAllSessionTickets(Session session) {
        return null;
    }

    @Override
    public boolean addTicket(Ticket ticket) {
        return false;
    }

    @Override
    public boolean updateTicket(Ticket ticketToUpdate, Ticket updatedTicket) {
        return false;
    }

    @Override
    public boolean deleteTicket(Ticket ticket) {
        return false;
    }
}
