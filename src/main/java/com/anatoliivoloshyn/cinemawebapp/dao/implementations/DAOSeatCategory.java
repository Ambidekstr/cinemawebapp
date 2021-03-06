package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSeatCategory;
import com.anatoliivoloshyn.cinemawebapp.entity.SeatCategory;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOSeatCategory implements IDAOSeatCategory {
    private static Logger logger = Logger.getLogger(DAOSeatCategory.class);
    private final String SELECT_ALL = "Select * from `seat_category`";
    private final String SELECT_BY_ID = "Select * from `seat_category` where `seat_category_id` = ?";
    private final String ADD_SEAT_CATEGORY = "Insert into `seat_category`(`seat_category`, `price`) values (?,?)";
    private final String UPDATE_SEAT_CATEGORY = "Update `seat_category` set `seat_category` = ?, `price` = ? where `seat_category_id` = ?";
    private final String DELETE_SEAT_CATEGORY = "Delete from `seat_category` where `seat_category_id` = ?";
    private Connection connection;
    private List<SeatCategory> seatCategoryList;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private SeatCategory seatCategoryDao;

    @Override
    public List<SeatCategory> findAllSeatCategory() {
        seatCategoryList = new LinkedList<>();
        try{
            connection = DataSource.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                seatCategoryDao = new SeatCategory(
                        resultSet.getLong("seat_category_id"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getString("seat_category"));
                seatCategoryList.add(seatCategoryDao);
            }
        }catch (SQLException e){
            logger.warn("Failed to find seat categories", e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return seatCategoryList;
    }

    @Override
    public SeatCategory findSeatCategoryById(long id) {
        try{
            connection = DataSource.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            seatCategoryDao = new SeatCategory(
                    resultSet.getLong("seat_category_id"),
                    resultSet.getBigDecimal("price"),
                    resultSet.getString("seat_category"));
        }catch (SQLException e){
            logger.warn("Failed to find seat category by id"+id, e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return seatCategoryDao;
    }

    @Override
    public boolean addSeatCategory(SeatCategory seatCategory) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_SEAT_CATEGORY);
            preparedStatement.setString(1,seatCategory.getSeatCategory());
            preparedStatement.setBigDecimal(2,seatCategory.getPrice());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to add seat category", e);
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
    public boolean updateSeatCategory(SeatCategory updatedSeatCategory) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(UPDATE_SEAT_CATEGORY);
            preparedStatement.setString(1, updatedSeatCategory.getSeatCategory());
            preparedStatement.setBigDecimal(2,updatedSeatCategory.getPrice());
            preparedStatement.setLong(3,updatedSeatCategory.getSeatCategoryId());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to update seat category", e);
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
    public boolean deleteSeatCategory(SeatCategory seatCategoryToDelete) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(DELETE_SEAT_CATEGORY);
            preparedStatement.setLong(1,seatCategoryToDelete.getSeatCategoryId());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to delete seat category", e);
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
