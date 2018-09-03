package com.anatoliivoloshyn.cinemawebapp.commands;

import com.anatoliivoloshyn.cinemawebapp.entity.Language;
import com.anatoliivoloshyn.cinemawebapp.entity.Role;
import com.anatoliivoloshyn.cinemawebapp.entity.User;
import com.anatoliivoloshyn.cinemawebapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUserCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserService();
        User user = new User();
        user.setPassword(request.getParameter("password"));
        user.setLogin(request.getParameter("email"));
        user.setRole(new Role(2l));
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        if(userService.registerUser(user)){
            return "/login.jsp";
        }
        return "/error.jsp";
    }
}
