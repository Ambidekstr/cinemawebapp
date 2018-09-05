package com.anatoliivoloshyn.cinemawebapp.service;

import com.anatoliivoloshyn.cinemawebapp.dao.DAOFactory;
import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOFilm;
import com.anatoliivoloshyn.cinemawebapp.entity.Film;

import java.util.List;
/**
 * Service class that is responsible for work with Films
 */
public class FilmService {
    private IDAOFilm idaoFilm;


    public FilmService() {
        idaoFilm = DAOFactory.getDAOFilm();
    }
    /**
     * Method that finds all films in data base.
     * @return List of Films if empty than there is no Films in the data base.
     */
    public List<Film> getAllFilms(){
        return idaoFilm.findAllFilms();
    }
}
