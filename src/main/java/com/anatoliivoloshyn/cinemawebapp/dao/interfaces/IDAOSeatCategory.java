package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.SeatCategory;

import java.math.BigDecimal;
import java.util.List;
/**
 * The interface that allows you to work with Seat Category table in the data base.
 */
public interface IDAOSeatCategory {
    /**
     * Method that finds all Seat Categories in data base.
     * @return List of Seat Categories if empty than there is no Seat Categories in the data base.
     */
    List<SeatCategory> findAllSeatCategory();
    /**
     * Method that finds Seat Category that correspond to Seat Category id.
     * @param id Seat Category id.
     * @return SeatCategory if null than there is no such Seat Category.
     */
    SeatCategory findSeatCategoryById(long id);
    /**
     * Method that add a new Seat Category to the data base.
     * @param seatCategory Seat Category that you want to add.
     * @return True if Seat Category is added successfully and false if not.
     */
    boolean addSeatCategory(SeatCategory seatCategory);
    /**
     * Method that updates an existing Seat Category in the data base.
     * @param updatedSeatCategory Updated Seat Category.
     * @return True if Seat Category is updated successfully and false if not.
     */
    boolean updateSeatCategory(SeatCategory updatedSeatCategory);
    /**
     * Method that deletes an existing Seat Category from the data base.
     * @param seatCategoryToDelete Seat Category that you want to delete.
     * @return True if Seat Category is deleted successfully and false if not.
     */
    boolean deleteSeatCategory(SeatCategory seatCategoryToDelete);
}
