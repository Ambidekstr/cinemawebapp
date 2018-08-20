package com.anatoliivoloshyn.cinemawebapp.commands;

import com.anatoliivoloshyn.cinemawebapp.entity.Film;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import com.anatoliivoloshyn.cinemawebapp.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Time;

public class UpdateExistingSessionCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SessionService sessionService = new SessionService();
        Session session = (Session)request.getSession().getAttribute("session");
        session.setFilm(new Film(Long.valueOf(request.getParameter("selectedFilm"))));
        session.setDate(Date.valueOf(request.getParameter("date")));
        session.setTime(Time.valueOf(request.getParameter("time")));
        if(sessionService.updateExistingSession(session)){
            return "/admin.jsp";
        }
        return "/error.jsp";
    }
}
