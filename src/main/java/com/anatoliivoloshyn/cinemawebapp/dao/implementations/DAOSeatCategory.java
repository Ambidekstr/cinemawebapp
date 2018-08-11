package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOSeatCategory;
import com.anatoliivoloshyn.cinemawebapp.entity.SeatCategory;

import java.math.BigDecimal;
import java.util.List;

public class DAOSeatCategory implements IDAOSeatCategory {
    @Override
    public List<SeatCategory> findAllSeatCategory() {
        return null;
    }

    @Override
    public BigDecimal getSeatCategoryPrice(String category) {
        return null;
    }

    @Override
    public boolean addSeatCategory(SeatCategory seatCategory) {
        return false;
    }

    @Override
    public boolean updateSeatCategory(SeatCategory seatCategoryToUpdate, SeatCategory updatedSeatCategory) {
        return false;
    }

    @Override
    public boolean deleteSeatCategory(String seatCategoryName) {
        return false;
    }
}
