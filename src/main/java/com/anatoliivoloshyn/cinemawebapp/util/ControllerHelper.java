package com.anatoliivoloshyn.cinemawebapp.util;

import com.anatoliivoloshyn.cinemawebapp.commands.ICommand;
import com.anatoliivoloshyn.cinemawebapp.commands.LoginCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ControllerHelper {
    private static ControllerHelper controllerHelper;
    private HashMap<String,ICommand> commandResolver;

    public ControllerHelper() {
        commandResolver = new HashMap<>();
        commandResolver.put("login", new LoginCommand());
    }

    public static ControllerHelper getInstance(){
        if(controllerHelper == null){
            controllerHelper = new ControllerHelper();
        }
        return controllerHelper;
    }

    public ICommand getCommand(HttpServletRequest request){
        return commandResolver.get(request.getParameter("command"));
    }
}
