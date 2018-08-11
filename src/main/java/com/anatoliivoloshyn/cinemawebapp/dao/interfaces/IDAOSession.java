package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Session;

import java.util.Date;
import java.util.List;

public interface IDAOSession {
    List<Session> findAllSessions();
    List<Session> findSessionsByFilmName(String filmName);
    List<Session> findSessionByDate(Date date);
    boolean addSession(Session session);
    boolean updateSession(Session sessionToUpdate, Session updatedSession);
    boolean deleteSession(Session session);
}
