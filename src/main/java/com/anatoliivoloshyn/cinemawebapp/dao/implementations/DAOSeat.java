package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSeat;
import com.anatoliivoloshyn.cinemawebapp.entity.Seat;

import java.util.List;

public class DAOSeat implements IDAOSeat {
    @Override
    public List<Seat> findAllSeats() {
        return null;
    }

    @Override
    public Seat findSeat(int row, int place) {
        return null;
    }

    @Override
    public boolean addSeat(Seat seat) {
        return false;
    }

    @Override
    public boolean deleteSeat(int row, int place) {
        return false;
    }

    @Override
    public boolean updateSeat(Seat seatForUpdate, Seat updatedSeat) {
        return false;
    }
}
