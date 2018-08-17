package com.anatoliivoloshyn.cinemawebapp.util;

import com.anatoliivoloshyn.cinemawebapp.commands.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ControllerHelper {
    private static ControllerHelper controllerHelper;
    private HashMap<String,ICommand> commandResolver;

    public ControllerHelper() {
        commandResolver = new HashMap<>();
        commandResolver.put("login", new LoginCommand());
        commandResolver.put("index", new IndexCommand());
        commandResolver.put("buyTicket", new BuyTicketCommand());
        commandResolver.put("order", new OrderCommand());
    }

    public static ControllerHelper getInstance(){
        if(controllerHelper == null){
            controllerHelper = new ControllerHelper();
        }
        return controllerHelper;
    }

    public ICommand getCommand(HttpServletRequest request){
        if(request.getParameter("command")==null){
            return commandResolver.get("index");
        }
        return commandResolver.get(request.getParameter("command"));
    }
}
