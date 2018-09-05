package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Seat;

import java.util.List;
/**
 * The interface that allows you to work with Seat table in the data base.
 */
public interface IDAOSeat {
    /**
     * Method that finds all Seats in data base.
     * @return List of Seats if empty than there is no Seats in the data base.
     */
    List<Seat> findAllSeats();
    /**
     * Method that finds Seat that correspond to Seat id.
     * @param id Seat id.
     * @return Seat if null than there is no such Seat.
     */
    Seat findSeatById(long id);
    /**
     * Method that add a new Seat to the data base.
     * @param seat Seat that you want to add.
     * @return True if Seat is added successfully and false if not.
     */
    boolean addSeat(Seat seat);
    /**
     * Method that deletes an existing Seat from the data base.
     * @param seat Seat that you want to delete.
     * @return True if Seat is deleted successfully and false if not.
     */
    boolean deleteSeat(Seat seat);
    /**
     * Method that updates an existing Seat in the data base.
     * @param updatedSeat Updated Seat.
     * @return True if Seat is updated successfully and false if not.
     */
    boolean updateSeat(Seat updatedSeat);
}
