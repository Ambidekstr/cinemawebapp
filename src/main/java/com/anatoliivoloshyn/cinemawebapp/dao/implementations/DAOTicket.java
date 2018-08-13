package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOTicket;
import com.anatoliivoloshyn.cinemawebapp.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DAOTicket implements IDAOTicket {
    private final String SELECT_ALL = "Select * from `ticket`";
    private final String SELECT_BY_ID = "Select * from `ticket` where `ticket_id` = ?";
    private final String ADD_TICKET = "Insert into `ticket`(`orders_id`,`seat_id`, `session_id`, `booked`) values (?,?,?,?)";
    private final String UPDATE_TICKET = "Update `ticket` set `orders_id` = ?, `seat_id` = ?, `session_id` = ?, `booked` = ? where `ticket_id` = ?";
    private final String DELETE_TICKET = "Delete from `ticket` where `ticket_id` = ?";
    private List<Ticket> ticketList;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Ticket ticketDao;

    @Override
    public List<Ticket> findAllTickets() {
        ticketList = new LinkedList<>();
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ticketDao = new Ticket(
                        resultSet.getLong("ticket_id"),
                        new Session(resultSet.getLong("session_id")),
                        new Order(resultSet.getLong("orders_id")),
                        new Seat(resultSet.getLong("seat_id")),
                        resultSet.getBoolean("booked"));
                ticketList.add(ticketDao);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ticketList;
    }

    @Override
    public Ticket findTicketById(long id) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            ticketDao = new Ticket(
                    resultSet.getLong("ticket_id"),
                    new Session(resultSet.getLong("session_id")),
                    new Order(resultSet.getLong("orders_id")),
                    new Seat(resultSet.getLong("seat_id")),
                    resultSet.getBoolean("booked"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ticketDao;
    }

    @Override
    public boolean addTicket(Ticket ticket) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(ADD_TICKET);
            preparedStatement.setLong(1,ticket.getOrder().getOrdersId());
            preparedStatement.setLong(2,ticket.getSeat().getSeatId());
            preparedStatement.setLong(3,ticket.getSession().getSessionId());
            preparedStatement.setBoolean(4,ticket.getBooked());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTicket(Ticket ticketToUpdate, Ticket updatedTicket) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(UPDATE_TICKET);
            preparedStatement.setLong(1, updatedTicket.getOrder().getOrdersId());
            preparedStatement.setLong(2,updatedTicket.getSeat().getSeatId());
            preparedStatement.setLong(3,updatedTicket.getSession().getSessionId());
            preparedStatement.setBoolean(4,updatedTicket.getBooked());
            preparedStatement.setLong(5,ticketToUpdate.getTicketId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteTicket(Ticket ticket) {
        try(Connection connection = DataSource.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(DELETE_TICKET);
            preparedStatement.setLong(1, ticket.getTicketId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
