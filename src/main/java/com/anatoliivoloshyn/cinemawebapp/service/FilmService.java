package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOFilm;
import com.anatoliivoloshyn.cinemawebapp.entity.Film;

import java.util.List;

public class FilmService {
    private IDAOFilm idaoFilm;


    public FilmService() {
        idaoFilm = DAOFactory.getDAOFilm();
    }

    public List<Film> getAllFims(){
        return idaoFilm.findAllFilms();
    }
}
