package com.anatoliivoloshyn.cinemawebapp.entity;

import java.sql.Time;

public class Film {
    private long filmId;

    private String ageRestriction;
    private String filmName;
    private String director;
    private String poster;
    private String trailerPath;

    private Time duration;

    public Film() {
    }

    public Film(long filmId, String ageRestriction, String filmName, String director, String poster, String trailerPath, Time duration) {
        this.filmId = filmId;
        this.ageRestriction = ageRestriction;
        this.filmName = filmName;
        this.director = director;
        this.poster = poster;
        this.trailerPath = trailerPath;
        this.duration = duration;
    }

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTrailerPath() {
        return trailerPath;
    }

    public void setTrailerPath(String trailerPath) {
        this.trailerPath = trailerPath;
    }
}
