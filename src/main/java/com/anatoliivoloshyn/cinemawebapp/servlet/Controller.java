package com.anatoliivoloshyn.cinemawebapp.servlet;

import com.anatoliivoloshyn.cinemawebapp.commands.ICommand;
import com.anatoliivoloshyn.cinemawebapp.util.ControllerHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand iCommand = ControllerHelper.getInstance().getCommand(req);
        iCommand.execute(req,resp);
        resp.sendRedirect("/main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand iCommand = ControllerHelper.getInstance().getCommand(req);
        resp.sendRedirect(iCommand.execute(req,resp));
    }
}
