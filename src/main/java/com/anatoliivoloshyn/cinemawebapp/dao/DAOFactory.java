package com.anatoliivoloshyn.cinemawebapp.dao;

import com.anatoliivoloshyn.cinemawebapp.dao.implementations.*;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.*;

public class DAOFactory {
    public static IDAOFilm getDAOFilm(){
        return new DAOFilm();
    }

    public static IDAOOrders getDAOOrders(){
        return new DAOOrders();
    }

    public static IDAORole getDAORole(){
        return new DAORole();
    }

    public static IDAOSeat getDAOSeat(){
        return new DAOSeat();
    }

    public static IDAOSeatCategory getDAOSeatCategory(){
        return new DAOSeatCategory();
    }

    public static IDAOSession getDAOSession(){
        return new DAOSession();
    }

    public static IDAOTicket getDAOTicket(){
        return new DAOTicket();
    }

    public static IDAOUser getDAOUser(){
        return new DAOUser();
    }
}
