package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.SeatCategory;

import java.math.BigDecimal;
import java.util.List;

public interface IDAOSeatCategory {
    List<SeatCategory> findAllSeatCategory();
    SeatCategory findSeatCategoryById(long id);
    boolean addSeatCategory(SeatCategory seatCategory);
    boolean updateSeatCategory(SeatCategory updatedSeatCategory);
    boolean deleteSeatCategory(SeatCategory seatCategoryToDelete);
}
