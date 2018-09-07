package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOFilm;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSession;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
/**
 * Service class that is responsible for work with Sessions
 */
public class SessionService {
    private List<Session> sessions;
    private IDAOSession daoSession;
    private IDAOFilm daoFilm;

    public SessionService() {
        daoSession = DAOFactory.getDAOSession();
        daoFilm = DAOFactory.getDAOFilm();
        sessions = new LinkedList<>();
    }
    /**
     * Method that finds all Sessions in data base.
     * @return List of Sessions if empty than there is no Sessions in the data base.
     */
    public List<Session> getSessions(){
        sessions = daoSession.findAllSessions();
        for (Session s: sessions) {
            s.setFilm(daoFilm.findById(s.getFilm().getFilmId()));
        }
        return sessions;
    }
    /**
     * Method that finds all Sessions in data base.
     * @return List of Sessions if empty than there is no Sessions in the data base.
     */
    public List<Session> getSessionsWithLimit(int from){
        sessions = daoSession.findAllSessionsWithLimit(from);
        for (Session s: sessions) {
            s.setFilm(daoFilm.findById(s.getFilm().getFilmId()));
        }
        return sessions;
    }
    /**
     * Method that finds Session that correspond to Session id.
     * @param sessionId Session id.
     * @return Session if null than there is no such Session.
     */
    public Session getSessionById(long sessionId){
        return daoSession.findSessionById(sessionId);
    }
    /**
     * Method that add a new Session to the data base.
     * @param session Session that you want to add.
     * @return Session if null than there is no such Session.
     */
    public Session addSession(Session session){
        Session s = daoSession.addSession(session);
        if(s!=null){
            return s;
        }
        return null;
    }
    /**
     * Method that deletes an existing Session from the data base.
     * @param session Session that you want to delete.
     * @return True if Session is deleted successfully and false if not.
     */
    public boolean deleteSession(Session session){
        return daoSession.deleteSession(session);
    }
}
