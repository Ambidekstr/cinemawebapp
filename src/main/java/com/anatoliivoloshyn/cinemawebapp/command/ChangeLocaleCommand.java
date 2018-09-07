package com.anatoliivoloshyn.cinemawebapp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLocaleCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", request.getParameter("locale"));
        return "/main.jsp";
    }
}
