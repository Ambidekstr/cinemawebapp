package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Session;

import java.sql.Date;
import java.util.List;
/**
 * The interface that allows you to work with Session table in the data base.
 */
public interface IDAOSession {
    /**
     * Method that finds all Sessions in data base.
     * @return List of Sessions if empty than there is no Sessions in the data base.
     */
    List<Session> findAllSessions();
    /**
     * Method that finds all Sessions in data base limiting size of list.
     * @return List of Sessions if empty than there is no Sessions in the data base.
     */
    List<Session> findAllSessionsWithLimit(int from);
    /**
     * Method that finds Session that correspond to Session id.
     * @param id Session id.
     * @return Session if null than there is no such Session.
     */
    Session findSessionById(long id);
    /**
     * Method that add a new Session to the data base.
     * @param session Session that you want to add.
     * @return Session if null than there is no such Session.
     */
    Session addSession(Session session);
    /**
     * Method that updates an existing Session in the data base.
     * @param updatedSession Updated Session.
     * @return True if Session is updated successfully and false if not.
     */
    boolean updateSession(Session updatedSession);
    /**
     * Method that deletes an existing Session from the data base.
     * @param session Session that you want to delete.
     * @return True if Session is deleted successfully and false if not.
     */
    boolean deleteSession(Session session);
}
