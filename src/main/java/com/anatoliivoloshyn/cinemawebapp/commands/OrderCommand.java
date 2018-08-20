package com.anatoliivoloshyn.cinemawebapp.commands;

import com.anatoliivoloshyn.cinemawebapp.entity.Ticket;
import com.anatoliivoloshyn.cinemawebapp.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

public class OrderCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TicketService ticketService = new TicketService();
        List<Ticket> tickets = ticketService.resolveOrder(request.getParameterValues("ticketId"));
        BigDecimal price = BigDecimal.valueOf(1);
        for (Ticket ticket : tickets) {
            price = ticket.getSeat().getSeatCategory().getPrice();
        }
        request.getSession().setAttribute("ticketForOrder", tickets );
        request.getSession().setAttribute("totalPrice", price);
        return "/order.jsp";
    }
}
