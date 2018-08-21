package com.anatoliivoloshyn.cinemawebapp.commands;

import com.anatoliivoloshyn.cinemawebapp.entity.User;
import com.anatoliivoloshyn.cinemawebapp.service.SessionService;
import com.anatoliivoloshyn.cinemawebapp.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TicketService ticketService = new TicketService();
        User user = (User)request.getSession().getAttribute("user");
        if(user.getRole().getRoleId()==1L){
            SessionService sessionService = new SessionService();
            request.getSession().setAttribute("sessionList",sessionService.getSessions());
           return "/admin.jsp";
        }
        request.getSession().setAttribute("userTickets", ticketService.getUserTickets(user));
        return "/account.jsp";
    }
}
