package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Film;

import java.util.List;
/**
 * The interface that allows you to work with Film table in the data base
 */
public interface IDAOFilm {
    /**
     * Method that finds all film in data base.
     * @return List of Films if empty than there is no Films in the data base.
     */
    List<Film> findAllFilms();
    /**
     * Method that finds needed Film by id.
     * @param id Films id.
     * @return Film if null than there is no such film found.
     */
    Film findById(long id);
    /**
     * Method that add a new Film to the data base.
     * @param filmToAdd Film you want to add.
     * @return True if Film is added successfully and false if not.
     */
    boolean addFilm(Film filmToAdd);
    /**
     * Method that deletes an existing Film from the data base.
     * @param filmToDelete Film you want to delete.
     * @return True if Film is deleted successfully and false if not.
     */
    boolean deleteFilm(Film filmToDelete);
    /**
     * Method that updates an existing Film in the data base.
     * @param updatedFilm Updated Film.
     * @return True if Film is updated successfully and false if not.
     */
    boolean updateFilm(Film updatedFilm);
}
