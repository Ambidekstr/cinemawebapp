package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Film;

import java.util.List;

public interface IDAOFilm {
    List<Film> findAllFilms();
    Film findById(long id);
    boolean addFilm(Film filmToAdd);
    boolean deleteFilm(Film filmToDelete);
    boolean updateFilm(Film filmToUpdate, Film updatedFilm);
}
