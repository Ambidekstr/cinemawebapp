package com.anatoliivoloshyn.cinemawebapp.command;

import com.anatoliivoloshyn.cinemawebapp.entity.Film;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.service.SessionService;
import com.anatoliivoloshyn.cinemawebapp.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class AddNewSessionCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SessionService sessionService = new SessionService();
        TicketService ticketService = new TicketService();
        Session session = new Session();
        session.setFilm(new Film(Long.valueOf(request.getParameter("selectedFilm"))));
        session.setDate(Date.valueOf(request.getParameter("date")));
        session.setTime(request.getParameter("time"));

        session = sessionService.addSession(session);
        if(session != null){
            if(ticketService.addTicketsForSession(session)){
                return "/Controller?command=account";
            }
            sessionService.deleteSession(session);
            return "/error.jsp";
        }
        sessionService.deleteSession(session);
        return "/error.jsp";
    }
}
