package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.DataSource;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOTicket;
import com.anatoliivoloshyn.cinemawebapp.entity.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DAOTicket implements IDAOTicket {
    private static Logger logger = Logger.getLogger(DAOTicket.class);
    private final String SELECT_ALL = "Select * from `ticket`";
    private final String SELECT_BY_ID = "Select * from `ticket` where `ticket_id` = ?";
    private final String SELECT_BY_SESSION_ID = "Select * from `ticket` where `session_id` = ?";
    private final String SELECT_BY_ORDER = "Select * from `ticket` where `orders_id` = ?";
    private final String ADD_TICKET = "Insert into `ticket`(`seat_id`, `session_id`, `booked`) values (?,?,?)";
    private final String UPDATE_TICKET = "Update `ticket` set `orders_id` = ?,`seat_id` = ?, `session_id` = ?, `booked` = ? where `ticket_id` = ?";
    private final String DELETE_TICKET = "Delete from `ticket` where `ticket_id` = ?";
    private Connection connection;
    private List<Ticket> ticketList;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Ticket ticketDao;

    @Override
    public List<Ticket> findAllTickets() {
        ticketList = new LinkedList<>();
        try{
            connection = DataSource.getInstance().getConnection();
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
            logger.warn("Failed to find tickets", e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return ticketList;
    }

    @Override
    public List<Ticket> findAllTicketsBySession(Session session) {
        ticketList = new LinkedList<>();
        try{
            connection = DataSource.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_SESSION_ID);
            preparedStatement.setLong(1,session.getSessionId());
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
            logger.warn("Failed to find ticket by session"+session, e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return ticketList;
    }

    @Override
    public List<Ticket> findAllTicketsByOrder(Order order) {
        ticketList = new LinkedList<>();
        try{
            connection = DataSource.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_ORDER);
            preparedStatement.setLong(1,order.getOrdersId());
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
            logger.warn("Failed to find tickets by order"+order, e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return ticketList;
    }

    @Override
    public Ticket findTicketById(long id) {
        try{
            connection = DataSource.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            ticketDao = new Ticket(
                    resultSet.getLong("ticket_id"),
                    new Session(resultSet.getLong("session_id")),
                    new Order(resultSet.getLong("orders_id")),
                    new Seat(resultSet.getLong("seat_id")),
                    resultSet.getBoolean("booked"));
        }catch (SQLException e){
            logger.warn("Failed to find ticket by id"+id, e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
        return ticketDao;
    }

    @Override
    public boolean addTicket(Ticket... tickets) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            for (Ticket ticket: tickets) {
                preparedStatement = connection.prepareStatement(ADD_TICKET);
                preparedStatement.setLong(1, ticket.getSeat().getSeatId());
                preparedStatement.setLong(2, ticket.getSession().getSessionId());
                preparedStatement.setBoolean(3, ticket.getBooked());
                preparedStatement.execute();
            }
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to add ticket", e);
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
    public boolean updateTicket(Ticket updatedTicket) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(UPDATE_TICKET);
            preparedStatement.setLong(1,updatedTicket.getOrder().getOrdersId());
            preparedStatement.setLong(2,updatedTicket.getSeat().getSeatId());
            preparedStatement.setLong(3,updatedTicket.getSession().getSessionId());
            preparedStatement.setBoolean(4,updatedTicket.getBooked());
            preparedStatement.setLong(5,updatedTicket.getTicketId());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to update ticket", e);
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
    public boolean deleteTicket(Ticket ticket) {
        try{
            connection = DataSource.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(DELETE_TICKET);
            preparedStatement.setLong(1, ticket.getTicketId());
            preparedStatement.execute();
            connection.commit();
        }catch (SQLException e){
            logger.warn("Failed to delete ticket", e);
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
