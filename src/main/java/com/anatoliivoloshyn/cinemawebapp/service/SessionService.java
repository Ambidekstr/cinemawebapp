package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOFilm;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSession;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import org.apache.log4j.Logger;

import java.util.List;

public class SessionService {
    private static Logger logger = Logger.getLogger(SessionService.class);
    private List<Session> sessions;

    public List<Session> getSessions(){
        IDAOSession daoSession = DAOFactory.getDAOSession();
        IDAOFilm daoFilm = DAOFactory.getDAOFilm();
        sessions = daoSession.findAllSessions();
        for (Session s: sessions) {
            s.setFilm(daoFilm.findById(s.getFilm().getFilmId()));
        }
        return sessions;
    }
}
