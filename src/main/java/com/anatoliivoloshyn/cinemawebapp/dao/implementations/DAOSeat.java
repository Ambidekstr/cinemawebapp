package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSeat;
import com.anatoliivoloshyn.cinemawebapp.entity.Seat;
import com.anatoliivoloshyn.cinemawebapp.entity.SeatCategory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOSeat implements IDAOSeat {
    private static Logger logger = Logger.getLogger(DAOSeat.class);
    private final String SELECT_ALL = "Select * from `seat`";
    private final String SELECT_BY_ID = "Select * from `seat` where `seat_id` = ?";
    private final String ADD_SEAT = "Insert into `seat`(`seat_category_id`, `seat_row`, `seat_place`)  values (?,?,?)";
    private final String UPDATE_SEAT = "Update `film` set `seat_category_id` = ?, `seat_row` = ?, `seat_place` = ? where `seat_id` = ?";
    private final String DELETE_SEAT = "Delete from `film` where `seat_id` = ?";
    private List<Seat> seatList;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Seat seatDao;

    @Override
    public List<Seat> findAllSeats() {
        seatList = new LinkedList<>();
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                seatDao = new Seat(
                        resultSet.getLong("seat_id"),
                        new SeatCategory(resultSet.getLong("seat_category_id")),
                        resultSet.getInt("seat_row"),
                        resultSet.getInt("seat_place"));
                seatList.add(seatDao);
            }
        }catch (SQLException e){
            logger.warn("Failed to find seats", e);
        }
        return seatList;
    }

    @Override
    public Seat findSeatById(long id) {
        try (Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            seatDao = new Seat(
                    resultSet.getLong("seat_id"),
                    new SeatCategory(resultSet.getLong("seat_category_id")),
                    resultSet.getInt("seat_row"),
                    resultSet.getInt("seat_place"));
        }catch (SQLException e){
            logger.warn("Failed to find seat by id"+id, e);
        }
        return seatDao;
    }

    @Override
    public boolean addSeat(Seat seat) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(ADD_SEAT);
            preparedStatement.setLong(1, seat.getSeatCategory().getSeatCategoryId());
            preparedStatement.setInt(2,seat.getSeatRow());
            preparedStatement.setInt(3,seat.getSeatPlace());
            preparedStatement.execute();
        }catch (SQLException e){
            logger.warn("Failed to add seat", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteSeat(Seat seat) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(DELETE_SEAT);
            preparedStatement.setLong(1, seat.getSeatId());
            preparedStatement.execute();
        }catch (SQLException e){
            logger.warn("Failed to delete seat", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSeat(Seat seatForUpdate, Seat updatedSeat) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(UPDATE_SEAT);
            preparedStatement.setLong(1, updatedSeat.getSeatCategory().getSeatCategoryId());
            preparedStatement.setInt(2,updatedSeat.getSeatRow());
            preparedStatement.setInt(3,updatedSeat.getSeatPlace());
            preparedStatement.setLong(4,seatForUpdate.getSeatId());
            preparedStatement.execute();
        }catch (SQLException e){
            logger.warn("Failed to update seat", e);
            return false;
        }
        return true;
    }
}
