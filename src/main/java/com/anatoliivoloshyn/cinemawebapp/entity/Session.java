package com.anatoliivoloshyn.cinemawebapp.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Session implements Serializable {
    private long sessionId;

    private Film film;

    private Date date;

    private String time;

    public Session() {

    }

    public Session(long sessionId) {
        this.sessionId = sessionId;
    }

    public Session(long sessionId, Film film, Date date, String time) {
        this.sessionId = sessionId;
        this.film = film;
        this.date = date;
        this.time = time;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return sessionId == session.sessionId &&
                Objects.equals(film, session.film) &&
                Objects.equals(date, session.date) &&
                Objects.equals(time, session.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, film, date, time);
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", film=" + film +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
