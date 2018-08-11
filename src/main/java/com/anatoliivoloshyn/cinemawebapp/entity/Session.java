package com.anatoliivoloshyn.cinemawebapp.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import java.util.Objects;

public class Session implements Serializable {
    private long sessionId;

    private Film film;

    private Date date;

    private Time time;

    private String sessionLanguage;

    public Session() {

    }

    public Session(long sessionId, Film film, Date date, Time time, String sessionLanguage) {
        this.sessionId = sessionId;
        this.film = film;
        this.date = date;
        this.time = time;
        this.sessionLanguage = sessionLanguage;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return sessionId == session.sessionId &&
                Objects.equals(film, session.film) &&
                Objects.equals(date, session.date) &&
                Objects.equals(time, session.time) &&
                Objects.equals(sessionLanguage, session.sessionLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, film, date, time, sessionLanguage);
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", film=" + film +
                ", date=" + date +
                ", time=" + time +
                ", sessionLanguage='" + sessionLanguage + '\'' +
                '}';
    }
}
