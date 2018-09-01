package com.anatoliivoloshyn.cinemawebapp.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Command that returns a String that represent uri based on the parameters from
 * handling HttpServletRequest and HttpServletResponse
 * @return URI
 */
public interface ICommand {
    String execute(HttpServletRequest request, HttpServletResponse response);
}
