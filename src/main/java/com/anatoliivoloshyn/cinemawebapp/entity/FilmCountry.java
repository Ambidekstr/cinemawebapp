package com.anatoliivoloshyn.cinemawebapp.entity;

public class FilmCountry {
    private Film film;

    private Country country;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
