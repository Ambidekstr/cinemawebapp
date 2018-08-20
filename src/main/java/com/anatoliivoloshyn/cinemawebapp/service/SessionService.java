package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOFilm;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSession;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class SessionService {
    private static Logger logger = Logger.getLogger(SessionService.class);
    private List<Session> sessions;
    private IDAOSession daoSession;
    private IDAOFilm daoFilm;

    public SessionService() {
        daoSession = DAOFactory.getDAOSession();
        daoFilm = DAOFactory.getDAOFilm();
        sessions = new LinkedList<>();
    }

    public List<Session> getSessions(){
        sessions = daoSession.findAllSessions();
        for (Session s: sessions) {
            s.setFilm(daoFilm.findById(s.getFilm().getFilmId()));
        }
        return sessions;
    }

    public Session getSessionById(long sessionId){
        return daoSession.findSessionById(sessionId);
    }

    public boolean updateExistingSession(Session session){
        if(daoSession.updateSession(session)){
            return true;
        }
        return false;
    }

    public boolean addSession(Session session){
        if(daoSession.addSession(session)){
            return true;
        }
        return false;
    }
}
