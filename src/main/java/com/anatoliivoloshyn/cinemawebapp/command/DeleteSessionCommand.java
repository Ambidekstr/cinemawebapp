package com.anatoliivoloshyn.cinemawebapp.command;

import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.service.SessionService;
import com.anatoliivoloshyn.cinemawebapp.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteSessionCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SessionService sessionService = new SessionService();
        TicketService ticketService = new TicketService();
        Session session = sessionService.getSessionById(Long.valueOf(request.getParameter("sessionId")));
        if(ticketService.deleteTicketsBySession(session)){
            if(sessionService.deleteSession(session)){
                return "/Controller?command=account";
            }
            return "/error";
        }
        return "/error";
    }
}
