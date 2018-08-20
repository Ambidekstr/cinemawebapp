package com.anatoliivoloshyn.cinemawebapp.commands;

import com.anatoliivoloshyn.cinemawebapp.entity.User;
import com.anatoliivoloshyn.cinemawebapp.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUserCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LoginService loginService = new LoginService();
        User user = loginService.login(request.getParameter("username"), request.getParameter("password"));
        if(user!=null){
            user.setPassword(null);
            request.getSession().setAttribute("user",user);
            return "/main.jsp";
        }
        return "/error.jsp";
    }
}
