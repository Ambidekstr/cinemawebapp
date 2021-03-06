package com.anatoliivoloshyn.cinemawebapp.command;

import com.anatoliivoloshyn.cinemawebapp.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyTicketCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TicketService ticketService = new TicketService();
        request.getSession().setAttribute("ticketList",ticketService.getAvailableTickets(Long.valueOf(request.getParameter("sessionId"))));
        return "/ticket.jsp";
    }
}
