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
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(iCommand.execute(req,resp));
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand iCommand = ControllerHelper.getInstance().getCommand(req);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(iCommand.execute(req,resp));
        requestDispatcher.forward(req,resp);
    }
}
