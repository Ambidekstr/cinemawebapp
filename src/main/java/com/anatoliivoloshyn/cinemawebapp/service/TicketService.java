package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.*;
import com.anatoliivoloshyn.cinemawebapp.entity.*;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
/**
 * Service class that is responsible for work with Tickets
 */
public class TicketService {
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
    /**
     * Method that finds all Tickets that correspond to this Session.
     * @param sessionId Session id
     * @return List of Tickets' lists if empty than there is no Tickets that correspond to this Session.
     */
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
    /**
     * Method that marks tickets as booked and adds order for user who bought these tickets.
     * @param ticketId Tickets that user have choose
     * @param user User who is making an order
     * @return List of Tickets that was bought if empty than something went wrong.
     */
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
    /**
     * Method that returns tickets that was bought by user.
     * @param user User whose tickers we want to see
     * @return List of Tickets if empty than there is no Tickets that correspond to this user.
     */
    public List<Ticket> getUserTickets(User user){
        orderList = daoOrders.findOrdersByUser(user.getUserId());
        for (Order order : orderList) {
            ticketList.addAll(daoTicket.findAllTicketsByOrder(order));
        }
        ticketList = fillTicket(ticketList);
        return ticketList;
    }
    /**
     * Method that returns enriched tickets to confirm the order.
     * @param ticketId Tickets that user have peeked
     * @return List of enriched Tickets if empty than something went wrong.
     */
    public List<Ticket> resolveOrder(String [] ticketId){
        for (String s: ticketId) {
            ticketList.add(daoTicket.findTicketById(Long.valueOf(s)));
        }
        ticketList = fillTicket(ticketList);
        return ticketList;

    }
    /**
     * Method that adds tickets for the new Session.
     * @param session Session to which we want to add tickets.
     * @return True if Tickets were added successfully and false if not.
     */
    public boolean addTicketsForSession(Session session){
        for(Seat s: daoSeat.findAllSeats()){
            ticket = new Ticket();
            ticket.setSeat(s);
            ticket.setSession(session);
            ticket.setBooked(false);
            ticketList.add(ticket);
        }
        return daoTicket.addTicket(ticketList.toArray(new Ticket[ticketList.size()]));
    }
    /**
     * Method that deletes an existing Tickets corresponding to given session.
     * @param session Session from which we want to delete tickets.
     * @return True if Tickets were deleted successfully and false if not.
     */
    public boolean deleteTicketsBySession(Session session){
        List<Ticket> ticketsToDelete = daoTicket.findAllTicketsBySession(session);
        daoTicket.deleteTicket(ticketsToDelete.toArray(new Ticket[ticketsToDelete.size()]));
        return daoTicket.findAllTicketsBySession(session).isEmpty();
    }
    /**
     * Method that enriches tickets with seats, seat's categories, sessions and films.
     * @param tickets List of tickets you want to enrich.
     * @return List of enriched tickets.
     */
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
