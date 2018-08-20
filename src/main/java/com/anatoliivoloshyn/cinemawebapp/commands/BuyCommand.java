package com.anatoliivoloshyn.cinemawebapp.commands;

import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;
import com.anatoliivoloshyn.cinemawebapp.entity.User;
import com.anatoliivoloshyn.cinemawebapp.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BuyCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TicketService ticketService = new TicketService();
        List<Ticket> checkedTickets = ticketService.buyTickets(request.getParameterValues("ticketId"),
                (User)request.getSession().getAttribute("user"));
        if(checkedTickets!=null){
            request.getSession().setAttribute("checkedTickets", checkedTickets);
            return "/main.jsp";
        }
        return "/error.jsp";
    }
}
