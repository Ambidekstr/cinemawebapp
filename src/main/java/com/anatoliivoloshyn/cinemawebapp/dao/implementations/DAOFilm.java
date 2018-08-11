package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOFilm;
import com.anatoliivoloshyn.cinemawebapp.entity.Film;

import java.util.List;

public class DAOFilm implements IDAOFilm {
    @Override
    public List<Film> findAllFilms() {
        return null;
    }

    @Override
    public Film findByName(String name) {
        return null;
    }

    @Override
    public Film findByDirector(String directorsName) {
        return null;
    }

    @Override
    public boolean addFilm(Film film) {
        return false;
    }

    @Override
    public boolean deleteFilm(Film film) {
        return false;
    }

    @Override
    public boolean updateFilm(Film filmToUpdate, Film updatedFilm) {
        return false;
    }
}
