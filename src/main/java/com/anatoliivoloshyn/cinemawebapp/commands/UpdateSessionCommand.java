package com.anatoliivoloshyn.cinemawebapp.commands;

import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.service.FilmService;
import com.anatoliivoloshyn.cinemawebapp.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateSessionCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SessionService sessionService = new SessionService();
        FilmService filmService = new FilmService();
        Session session = sessionService.getSessionById(Long.valueOf(request.getParameter("sessionId")));
        request.getSession().setAttribute("session", session);
        request.getSession().setAttribute("films",filmService.getAllFims());
        return "/addSession.jsp";
    }
}
