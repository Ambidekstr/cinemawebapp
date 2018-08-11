package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Film;

import java.util.List;

public interface IDAOFilm {
    List<Film> findAllFilms();
    Film findByName(String name);
    Film findByDirector(String directorsName);
    boolean addFilm(Film film);
    boolean deleteFilm(Film film);
    boolean updateFilm(Film filmToUpdate, Film updatedFilm);
}
