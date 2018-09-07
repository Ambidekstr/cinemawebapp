package com.anatoliivoloshyn.cinemawebapp.command;

import com.anatoliivoloshyn.cinemawebapp.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SessionService sessionService = new SessionService();
        request.getSession().setAttribute("sessionList",sessionService.getSessionsWithLimit(0));
        request.getSession().setAttribute("previousPage",0);
        return "/main.jsp";
    }
}
