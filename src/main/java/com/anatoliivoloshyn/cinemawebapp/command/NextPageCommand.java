package com.anatoliivoloshyn.cinemawebapp.command;

import com.anatoliivoloshyn.cinemawebapp.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NextPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int previousPageNumber = (Integer) request.getSession().getAttribute("previousPage");
        SessionService sessionService = new SessionService();
        request.getSession().setAttribute("sessionList",sessionService.getSessionsWithLimit((++previousPageNumber)*7));
        request.getSession().setAttribute("previousPage", previousPageNumber);
        return "/main.jsp";
    }
}
