package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.SeatCategory;

import java.math.BigDecimal;
import java.util.List;

public interface IDAOSeatCategory {
    List<SeatCategory> findAllSeatCategory();
    BigDecimal getSeatCategoryPrice(String category);
    boolean addSeatCategory(SeatCategory seatCategory);
    boolean updateSeatCategory(SeatCategory seatCategoryToUpdate, SeatCategory updatedSeatCategory);
    boolean deleteSeatCategory(String seatCategoryName);
}
