package com.anatoliivoloshyn.cinemawebapp.entity;

import java.sql.Time;
import java.util.Date;

public class Session {
    private long sessionId;

    private Film film;

    private Date date;

    private Time time;

    private String sessionLanguage;

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getSessionLanguage() {
        return sessionLanguage;
    }

    public void setSessionLanguage(String sessionLanguage) {
        this.sessionLanguage = sessionLanguage;
    }
}
