package com.anatoliivoloshyn.cinemawebapp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("user",null);
        return "/main.jsp";
    }
}
