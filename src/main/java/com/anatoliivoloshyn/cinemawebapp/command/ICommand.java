package com.anatoliivoloshyn.cinemawebapp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Command that handles HttpServletRequest and HttpServletResponse.
 */
public interface ICommand {
    /**
     * Method that handles HttpServletRequest and HttpServletResponse based on the parameters
     * @param request HttpServletRequest.
     * @param response HttpServletResponse.
     * @return String that is URL
     */
    String execute(HttpServletRequest request, HttpServletResponse response);
}
