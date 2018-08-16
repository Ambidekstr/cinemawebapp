package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSession;
import com.anatoliivoloshyn.cinemawebapp.entity.Film;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.Date;


public class DAOSession implements IDAOSession {
    private static final String SELECT_ALL = "Select * from session";
    private List<Session> sessionList;

    @Override
    public List<Session> findAllSessions() {
        sessionList = new LinkedList<>();
        try(Connection connection = DataSource.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Session session = new Session(
                        resultSet.getLong("session_id"),
                        new Film(resultSet.getLong("film_id")),
                        resultSet.getDate("date"),
                        resultSet.getTime("time"),
                        resultSet.getString("session_language"));
                sessionList.add(session);
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Session> findSessionsByFilmName(String filmName) {
        return null;
    }

    @Override
    public List<Session> findSessionByDate(Date date) {
        return null;
    }

    @Override
    public boolean addSession(Session session) {
        return false;
    }

    @Override
    public boolean updateSession(Session sessionToUpdate, Session updatedSession) {
        return false;
    }

    @Override
    public boolean deleteSession(Session session) {
        return false;
    }
}
