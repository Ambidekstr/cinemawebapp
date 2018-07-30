package com.anatoliivoloshyn.cinemawebapp.entity;

public class FilmGenre {
    private Film film;

    private Genre genre;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
