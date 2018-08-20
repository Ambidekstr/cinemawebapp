package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOOrders;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSeat;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOTicket;
import com.anatoliivoloshyn.cinemawebapp.entity.Order;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;
import com.anatoliivoloshyn.cinemawebapp.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class TicketService {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    private static Logger logger = Logger.getLogger(TicketService.class);
    private List<Ticket> ticketList;
    private Ticket ticket;
    private List<List<Ticket>> listOfTicketList;
    private IDAOTicket daoTicket;
    private IDAOSeat daoSeat;
    private IDAOOrders daoOrders;
    private Order order;

    public TicketService() {
        daoTicket = DAOFactory.getDAOTicket();
        daoSeat = DAOFactory.getDAOSeat();
        daoOrders = DAOFactory.getDAOOrders();
        ticket = new Ticket();
        order = new Order();
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

    public boolean buyTickets(String[] ticketId, User user){
        order.setOrdersDateTime(new Timestamp(System.currentTimeMillis()));
        order.setUser(user);
        order = daoOrders.addOrder(order);
        for (String s: ticketId) {
            ticket = daoTicket.findTicketById(Long.valueOf(s));
            ticket.setBooked(true);
            ticket.setOrder(order);
            daoTicket.updateTicket(ticket);
        }
        return true;
    }
}
