package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAORole;
import com.anatoliivoloshyn.cinemawebapp.entity.Role;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAORole implements IDAORole {
    private static Logger logger = Logger.getLogger(DAORole.class);
    private final String SELECT_ALL = "Select * from `role`";
    private final String SELECT_BY_ID = "Select * from `role` where `role_id` = ?";
    private final String ADD_ROLE = "Insert into `role`(`role`) values (?)";
    private final String DELETE_ROLE = "Delete from `role` where `role_id` = ?";
    private Connection connection;
    private List<Role> roleList;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Role roleDao;

    @Override
    public List<Role> findAllRoles() {
        roleList = new LinkedList<>();
        try{
            connection = DataSource.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                roleDao = new Role(
                        resultSet.getLong("role_id"),
                        resultSet.getString("role"));
                roleList.add(roleDao);
            }
        }catch (SQLException e){
            logger.warn("Failed to find roles", e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return roleList;
    }

    @Override
    public Role findById(long id) {
        try{
            connection = DataSource.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            roleDao = new Role(
                    resultSet.getLong("role_id"),
                    resultSet.getString("role"));
        }catch (SQLException e){
            logger.warn("Failed to find role by id"+id, e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return roleDao;
    }

    @Override
    public boolean addRole(Role role) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_ROLE);
            preparedStatement.setString(1,role.getRole());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to add role", e);
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
    public boolean deleteRole(Role role) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(DELETE_ROLE);
            preparedStatement.setLong(1,role.getRoleId());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to delete role", e);
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
