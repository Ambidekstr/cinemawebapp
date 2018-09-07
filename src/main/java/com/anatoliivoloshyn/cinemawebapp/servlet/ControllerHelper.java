package com.anatoliivoloshyn.cinemawebapp.servlet;

import com.anatoliivoloshyn.cinemawebapp.command.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
/**
 * Class helper that resolves which command should be used to handle the request
 */
public class ControllerHelper {
    private static ControllerHelper controllerHelper;
    private HashMap<String,ICommand> commandResolver;

    public ControllerHelper() {
        commandResolver = new HashMap<>();
        commandResolver.put("login", new LoginCommand());
        commandResolver.put("index", new IndexCommand());
        commandResolver.put("buyTicket", new BuyTicketCommand());
        commandResolver.put("order", new OrderCommand());
        commandResolver.put("buy", new BuyCommand());
        commandResolver.put("loginUser", new LoginUserCommand());
        commandResolver.put("registration", new RegistrationCommand());
        commandResolver.put("registerUser", new RegisterUserCommand());
        commandResolver.put("account", new AccountCommand());
        commandResolver.put("addSession", new AddSessionCommand());
        commandResolver.put("deleteSession", new DeleteSessionCommand());
        commandResolver.put("addNewSession", new AddNewSessionCommand());
        commandResolver.put("changeLocale", new ChangeLocaleCommand());
        commandResolver.put("logOut", new LogOutCommand());
        commandResolver.put("previousPage", new PreviousPageCommand());
        commandResolver.put("nextPage", new NextPageCommand());
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
