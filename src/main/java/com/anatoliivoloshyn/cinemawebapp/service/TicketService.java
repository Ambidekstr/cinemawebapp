package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSeat;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSeatCategory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOTicket;
import com.anatoliivoloshyn.cinemawebapp.entity.Seat;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class TicketService {
    private static Logger logger = Logger.getLogger(TicketService.class);
    private List<Ticket> ticketList;
    private List<List<Ticket>> listOfTiketList;
    private Seat seat;

    public List<List<Ticket>> getTickets(long sessionId){
        IDAOTicket daoTicket = DAOFactory.getDAOTicket();
        IDAOSeat daoSeat = DAOFactory.getDAOSeat();
        IDAOSeatCategory daoSeatCategory = DAOFactory.getDAOSeatCategory();
        ticketList = daoTicket.findAllTicketsBySession(new Session(sessionId));
        for (Ticket t: ticketList) {
            seat=daoSeat.findSeatById(t.getSeat().getSeatId());
            seat.setSeatCategory(daoSeatCategory.findSeatCategoryById(seat.getSeatCategory().getSeatCategoryId()));
            t.setSeat(seat);
        }
        listOfTiketList = new LinkedList<>();
        listOfTiketList.add(ticketList.subList(0,10));
        listOfTiketList.add(ticketList.subList(10,20));
        listOfTiketList.add(ticketList.subList(20,30));
        listOfTiketList.add(ticketList.subList(30,40));
        listOfTiketList.add(ticketList.subList(40,48));
        return listOfTiketList;
    }
}
