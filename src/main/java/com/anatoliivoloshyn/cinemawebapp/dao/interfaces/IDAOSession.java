package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Session;

import java.sql.Date;
import java.util.List;

public interface IDAOSession {
    List<Session> findAllSessions();
    Session findSessionById(long id);
    boolean addSession(Session session);
    boolean updateSession(Session updatedSession);
    boolean deleteSession(Session session);
}
