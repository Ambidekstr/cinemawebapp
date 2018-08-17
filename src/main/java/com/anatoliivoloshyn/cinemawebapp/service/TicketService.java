package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSeat;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOTicket;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class TicketService {
    private static Logger logger = Logger.getLogger(TicketService.class);
    private List<Ticket> ticketList;
    private List<List<Ticket>> listOfTicketList;

    public List<List<Ticket>> getTickets(Long sessionId){
        IDAOTicket daoTicket = DAOFactory.getDAOTicket();
        IDAOSeat daoSeat = DAOFactory.getDAOSeat();
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
}
