package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.*;
import com.anatoliivoloshyn.cinemawebapp.entity.*;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class TicketService {
    private static Logger logger = Logger.getLogger(TicketService.class);
    private List<Ticket> ticketList;
    private List<Order> orderList;
    private List<List<Ticket>> listOfTicketList;
    private IDAOTicket daoTicket;
    private IDAOSeat daoSeat;
    private IDAOOrders daoOrders;
    private IDAOSession idaoSession;
    private IDAOFilm idaoFilm;
    private IDAOSeatCategory idaoSeatCategory;

    private Order order;
    private Ticket ticket;
    private Seat seat;
    private Session session;
    private BigDecimal price;

    public TicketService() {
        daoTicket = DAOFactory.getDAOTicket();
        daoSeat = DAOFactory.getDAOSeat();
        daoOrders = DAOFactory.getDAOOrders();
        idaoSession = DAOFactory.getDAOSession();
        idaoFilm = DAOFactory.getDAOFilm();
        idaoSeatCategory = DAOFactory.getDAOSeatCategory();
        ticketList = new LinkedList<>();
        orderList = new LinkedList<>();
        listOfTicketList = new LinkedList<>();
        ticket = new Ticket();
        order = new Order();
        seat = new Seat();
        session = new Session();
    }

    public List<List<Ticket>> getAvailableTickets(Long sessionId){
        ticketList = daoTicket.findAllTicketsBySession(new Session(sessionId));
        for (Ticket t: ticketList) {
            t.setSeat(daoSeat.findSeatById(t.getSeat().getSeatId()));
        }

        listOfTicketList.add(ticketList.subList(0,10));
        listOfTicketList.add(ticketList.subList(10,20));
        listOfTicketList.add(ticketList.subList(20,30));
        listOfTicketList.add(ticketList.subList(30,40));
        listOfTicketList.add(ticketList.subList(40,48));
        return listOfTicketList;
    }

    public List<Ticket> buyTickets(String[] ticketId, User user){
        order.setOrdersDateTime(new Timestamp(System.currentTimeMillis()));
        order.setUser(user);
        order = daoOrders.addOrder(order);
        for (String s: ticketId) {
            ticket = daoTicket.findTicketById(Long.valueOf(s));
            ticket.setBooked(true);
            ticket.setOrder(order);
            daoTicket.updateTicket(ticket);
            ticketList.add(ticket);
        }
        return ticketList;
    }

    public List<Ticket> getUserTickets(User user){
        orderList = daoOrders.findOrdersByUser(user.getUserId());
        for (Order order : orderList) {
            ticketList.addAll(daoTicket.findAllTicketsByOrder(order));
        }
        ticketList = fillTicket(ticketList);
        return ticketList;
    }

    public List<Ticket> resolveOrder(String [] ticketId){
        for (String s: ticketId) {
            ticketList.add(daoTicket.findTicketById(Long.valueOf(s)));
        }
        ticketList = fillTicket(ticketList);
        return ticketList;

    }

    public boolean addTicketsForSession(Session session){
        for(Seat s: daoSeat.findAllSeats()){
            ticket = new Ticket();
            ticket.setSeat(s);
            ticket.setSession(session);
            ticket.setBooked(false);
            ticketList.add(ticket);
        }
        for(Ticket t: ticketList){
            daoTicket.addTicket(t);
        }
        return true;
    }

    public boolean deleteTicketsBySession(Session session){
        for(Ticket t: daoTicket.findAllTicketsBySession(session)){
            daoTicket.deleteTicket(t);
        }
        return daoTicket.findAllTicketsBySession(session).isEmpty();
    }

    private List<Ticket> fillTicket(List<Ticket> tickets){
        for (Ticket ticket : tickets) {
            seat = daoSeat.findSeatById(ticket.getSeat().getSeatId());
            seat.setSeatCategory(idaoSeatCategory.findSeatCategoryById(seat.getSeatCategory().getSeatCategoryId()));
            ticket.setSeat(seat);

            session = idaoSession.findSessionById(ticket.getSession().getSessionId());
            session.setFilm(idaoFilm.findById(session.getFilm().getFilmId()));
            ticket.setSession(session);
        }
        return tickets;
    }
}
