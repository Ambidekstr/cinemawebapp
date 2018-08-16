package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSession;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import org.apache.log4j.Logger;

import java.util.List;

public class SessionService {
    private static Logger logger = Logger.getLogger(SessionService.class);

    public List<Session> getSessions(){
        IDAOSession daoSession = DAOFactory.getDAOSession();
        return daoSession.findAllSessions();
    }
}
