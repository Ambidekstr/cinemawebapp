package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOUser;
import com.anatoliivoloshyn.cinemawebapp.entity.Language;
import com.anatoliivoloshyn.cinemawebapp.entity.Role;
import com.anatoliivoloshyn.cinemawebapp.entity.User;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOUser implements IDAOUser {
    private static Logger logger = Logger.getLogger(DAOUser.class);
    private final String SELECT_ALL = "Select * from `user`";
    private final String SELECT_BY_LOGIN = "Select * from `user` where `login` = ?";
    private final String SELECT_BY_ID = "Select * from `user` where `user_id` = ?";
    private final String ADD_USER = "Insert into `user`(`language_id`, `role_id`, `login`, `password`, `name`, `surname`) values (?,?,?,?,?,?)";
    private final String UPDATE_USER = "Update `user` set `language_id` = ?, `role_id` = ?, `login` = ?, `password` = ?, `name` = ?, `surname` = ? where `user_id` = ?";
    private final String DELETE_USER = "Delete from `user` where `user_id` = ?";
    private Connection connection;
    private List<User> userList;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private User userDao;

    @Override
    public List<User> findAllUsers() {
        userList = new LinkedList<>();
        try{
            connection = DataSource.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userDao = new User(
                        resultSet.getLong("user_id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        new Role(resultSet.getLong("role_id")),
                        new Language(resultSet.getLong("language_id")));
                userList.add(userDao);
            }
        }catch (SQLException e){
            logger.warn("Failed to find users", e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return userList;
    }

    @Override
    public User findUserByLogin(String login) {
        try{
            connection = DataSource.getInstance().getConnection();
            logger.info("Retriving a connection");
            preparedStatement = connection.prepareStatement(SELECT_BY_LOGIN);
            preparedStatement.setString(1,login);
            logger.info("Preparing statement");
            resultSet = preparedStatement.executeQuery();
            logger.info("Getting result set");
            resultSet.next();
            userDao = new User(
                    resultSet.getLong("user_id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    new Role(resultSet.getLong("role_id")),
                    new Language(resultSet.getLong("language_id")));
        }catch (SQLException e){
            logger.warn("Failed to find user by login"+login, e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return userDao;
    }

    @Override
    public User findUserById(long id) {
        try{
            connection = DataSource.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            userDao = new User(
                    resultSet.getLong("user_id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    new Role(resultSet.getLong("role_id")),
                    new Language(resultSet.getLong("language_id")));
        }catch (SQLException e){
            logger.warn("Failed to find user by id"+id, e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return userDao;
    }

    @Override
    public boolean addUser(User user) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_USER);
            preparedStatement.setLong(1,user.getLanguage().getLanguageId());
            preparedStatement.setLong(2,user.getRole().getRoleId());
            preparedStatement.setString(3,user.getLogin());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getName());
            preparedStatement.setString(6,user.getSurname());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to add user", e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                logger.warn("Failed to rollback", e1);
            }
            return false;
        }finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return true;
    }

    @Override
    public boolean updateUser(User userToUpdate, User updatedUser) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setLong(1,updatedUser.getLanguage().getLanguageId());
            preparedStatement.setLong(2,updatedUser.getRole().getRoleId());
            preparedStatement.setString(3,updatedUser.getLogin());
            preparedStatement.setString(4,updatedUser.getPassword());
            preparedStatement.setString(5,updatedUser.getName());
            preparedStatement.setString(6,updatedUser.getSurname());
            preparedStatement.setLong(7,userToUpdate.getUserId());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to update user", e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                logger.warn("Failed to rollback", e1);
            }
            return false;
        }finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return true;
    }

    @Override
    public boolean deleteUser(User user) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setLong(1,user.getUserId());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to delete user", e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                logger.warn("Failed to rollback", e1);
            }
            return false;
        }finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return true;
    }
}
