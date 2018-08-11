package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Seat;

import java.util.List;

public interface IDAOSeat {
    List<Seat> findAllSeats();
    Seat findSeat(int row, int place);
    boolean addSeat(Seat seat);
    boolean deleteSeat(int row, int place);
    boolean updateSeat(Seat seatForUpdate, Seat updatedSeat);
}
