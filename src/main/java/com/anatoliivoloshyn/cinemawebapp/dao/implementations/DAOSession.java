package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSession;
import com.anatoliivoloshyn.cinemawebapp.entity.Film;
import com.anatoliivoloshyn.cinemawebapp.entity.Session;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class DAOSession implements IDAOSession {
    private static Logger logger = Logger.getLogger(DAOSession.class);
    private final String SELECT_ALL = "Select * from `session`";
    private final String SELECT_BY_ID = "Select * from `session` where `session_id` = ?";
    private final String ADD_SESSION = "Insert into `session`(`film_id`, `date`, `time`) values (?,?,?)";
    private final String UPDATE_SESSION = "Update `session` set `film_id` = ?, `date` = ?, `time` = ? where `session_id` = ?";
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
                        resultSet.getString("time"));
                sessionList.add(sessionDao);
            }
        }catch (SQLException e){
            logger.warn("Failed to find sessions", e);
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
            resultSet.next();
            sessionDao = new Session(
                    resultSet.getLong("session_id"),
                    new Film(resultSet.getLong("film_id")),
                    resultSet.getDate("date"),
                    resultSet.getString("time"));
        }catch (SQLException e){
            logger.warn("Failed to find session by id"+id, e);
        }
        return sessionDao;
    }

    @Override
    public Session addSession(Session session) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(ADD_SESSION,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1,session.getFilm().getFilmId());
            preparedStatement.setDate(2,session.getDate());
            preparedStatement.setString(3,session.getTime());
            preparedStatement.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            session.setSessionId(resultSet.getLong(1));
        }catch (SQLException e){
            logger.warn("Failed to add session", e);
            return null;
        }
        return session;
    }

    @Override
    public boolean updateSession(Session updatedSession) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(UPDATE_SESSION);
            preparedStatement.setLong(1,updatedSession.getFilm().getFilmId());
            preparedStatement.setDate(2,updatedSession.getDate());
            preparedStatement.setString(3,updatedSession.getTime());
            preparedStatement.setLong(4,updatedSession.getSessionId());
            preparedStatement.execute();
        }catch (SQLException e){
            logger.warn("Failed to update session", e);
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
            logger.warn("Failed to delete session", e);
            return false;
        }
        return true;
    }
}
