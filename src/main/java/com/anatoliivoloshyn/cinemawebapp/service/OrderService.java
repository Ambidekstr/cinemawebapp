package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.*;
import com.anatoliivoloshyn.cinemawebapp.entity.Order;
import com.anatoliivoloshyn.cinemawebapp.entity.Seat;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class OrderService {
    private List<Ticket> ticketList;
    private Seat seat;
    private Session session;
    private BigDecimal price;

    public void resolveOrder(HttpServletRequest request){
        price = new BigDecimal(0);
        IDAOTicket idaoTicket = DAOFactory.getDAOTicket();
        IDAOSession idaoSession = DAOFactory.getDAOSession();
        IDAOFilm idaoFilm = DAOFactory.getDAOFilm();
        IDAOSeat idaoSeat = DAOFactory.getDAOSeat();
        IDAOSeatCategory idaoSeatCategory = DAOFactory.getDAOSeatCategory();
        ticketList = new LinkedList<>();
        for (String s: request.getParameterValues("ticketId")) {
            ticketList.add(idaoTicket.findTicketById(Long.valueOf(s)));
        }
        for (Ticket ticket : ticketList) {
            seat = idaoSeat.findSeatById(ticket.getSeat().getSeatId());
            seat.setSeatCategory(idaoSeatCategory.findSeatCategoryById(seat.getSeatCategory().getSeatCategoryId()));
            ticket.setSeat(seat);

            session = idaoSession.findSessionById(ticket.getSession().getSessionId());
            session.setFilm(idaoFilm.findById(session.getFilm().getFilmId()));
            ticket.setSession(session);
            price = price.add(ticket.getSeat().getSeatCategory().getPrice());
        }
        request.getSession().setAttribute("ticketForOrder", ticketList);
        request.getSession().setAttribute("totalPrice", price);
    }
}
