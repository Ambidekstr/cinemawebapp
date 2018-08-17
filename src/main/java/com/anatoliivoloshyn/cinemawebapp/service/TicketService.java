package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSeat;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOTicket;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

public class TicketService {
    private static Logger logger = Logger.getLogger(TicketService.class);
    private List<Ticket> ticketList;
    private Ticket ticket;
    private List<List<Ticket>> listOfTicketList;
    private IDAOTicket daoTicket;
    private IDAOSeat daoSeat;

    public TicketService() {
        daoTicket = DAOFactory.getDAOTicket();
        daoSeat = DAOFactory.getDAOSeat();
        ticket = new Ticket();
    }

    public List<List<Ticket>> getTickets(Long sessionId){
        ticketList = daoTicket.findAllTicketsBySession(new Session(sessionId));
        for (Ticket t: ticketList) {
            t.setSeat(daoSeat.findSeatById(t.getSeat().getSeatId()));
        }
        listOfTicketList = new LinkedList<>();
        listOfTicketList.add(ticketList.subList(0,10));
        listOfTicketList.add(ticketList.subList(10,20));
        listOfTicketList.add(ticketList.subList(20,30));
        listOfTicketList.add(ticketList.subList(30,40));
        listOfTicketList.add(ticketList.subList(40,48));
        return listOfTicketList;
    }

    public boolean buyTickets(HttpServletRequest request){
        for (String s: request.getParameterValues("ticketId")) {
            ticket = daoTicket.findTicketById(Long.valueOf(s));
            ticket.setBooked(true);
            daoTicket.updateTicket(new Ticket(Long.valueOf(s)),ticket);
        }
        return true;
    }
}
