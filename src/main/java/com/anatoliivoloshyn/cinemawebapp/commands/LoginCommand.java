package com.anatoliivoloshyn.cinemawebapp.commands;

import com.anatoliivoloshyn.cinemawebapp.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LoginService loginService = new LoginService();
        if(loginService.login(
                (String) request.getSession().getAttribute("username"),
                (String)request.getSession().getAttribute("password"))){
            return "/main.jsp";
        }
        return "/error.jsp";
    }
}
