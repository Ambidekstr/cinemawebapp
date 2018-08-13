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
    private final String SELECT_ALL = "Select * from `session`";
    private final String SELECT_BY_ID = "Select * from `session` where `session_id` = ?";
    private final String ADD_SESSION = "Insert into `session`(`film_id`, `date`, `time`, `session_language`) values (?,?,?,?)";
    private final String UPDATE_SESSION = "Update `session` set `film_id` = ?, `date` = ?, `time` = ?, `session_language` = ? where `session_id` = ?";
    private final String DELETE_SESSION = "Delete from `session` where `session_id` = ?";
    private List<Session> sessionList;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Session sessionDao;

    @Override
    public List<Session> findAllSessions() {
        sessionList = new LinkedList<>();
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sessionDao = new Session(
                        resultSet.getLong("session_id"),
                        new Film(resultSet.getLong("film_id")),
                        resultSet.getDate("date"),
                        resultSet.getTime("time"),
                        resultSet.getString("session_language"));
                sessionList.add(sessionDao);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return sessionList;
    }

    @Override
    public Session findSessionById(long id) {
        sessionList = new LinkedList<>();
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
                sessionDao = new Session(
                        resultSet.getLong("session_id"),
                        new Film(resultSet.getLong("film_id")),
                        resultSet.getDate("date"),
                        resultSet.getTime("time"),
                        resultSet.getString("session_language"));
                sessionList.add(sessionDao);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return sessionDao;
    }

    @Override
    public boolean addSession(Session session) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(ADD_SESSION);
            preparedStatement.setLong(1,session.getFilm().getFilmId());
            preparedStatement.setDate(2,session.getDate());
            preparedStatement.setTime(3,session.getTime());
            preparedStatement.setString(4,session.getSessionLanguage());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSession(Session sessionToUpdate, Session updatedSession) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(UPDATE_SESSION);
            preparedStatement.setLong(1,updatedSession.getFilm().getFilmId());
            preparedStatement.setDate(2,updatedSession.getDate());
            preparedStatement.setTime(3,updatedSession.getTime());
            preparedStatement.setString(4,updatedSession.getSessionLanguage());
            preparedStatement.setLong(5,sessionToUpdate.getSessionId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteSession(Session session) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(DELETE_SESSION);
            preparedStatement.setLong(1,session.getSessionId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
