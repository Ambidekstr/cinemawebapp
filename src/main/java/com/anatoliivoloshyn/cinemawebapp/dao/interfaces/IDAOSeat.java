package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Seat;

import java.util.List;

public interface IDAOSeat {
    List<Seat> findAllSeats();
    Seat findSeatById(long id);
    boolean addSeat(Seat seat);
    boolean deleteSeat(Seat seat);
    boolean updateSeat(Seat updatedSeat);
}
