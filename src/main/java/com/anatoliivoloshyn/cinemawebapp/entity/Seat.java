package com.anatoliivoloshyn.cinemawebapp.entity;

import java.io.Serializable;
import java.util.Objects;

public class Seat implements Serializable {
    private long seatId;

    private SeatCategory seatCategory;

    private int seatRow;
    private int seatPlace;

    public Seat() {
    }

    public Seat(long seatId) {
        this.seatId = seatId;
    }

    public Seat(long seatId, SeatCategory seatCategory, int seatRow, int seatPlace) {

        this.seatId = seatId;
        this.seatCategory = seatCategory;
        this.seatRow = seatRow;
        this.seatPlace = seatPlace;
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatPlace() {
        return seatPlace;
    }

    public void setSeatPlace(int seatPlace) {
        this.seatPlace = seatPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return seatId == seat.seatId &&
                seatRow == seat.seatRow &&
                seatPlace == seat.seatPlace;
    }

    @Override
    public int hashCode() {

        return Objects.hash(seatId, seatRow, seatPlace);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", seatCategory=" + seatCategory +
                ", seatRow=" + seatRow +
                ", seatPlace=" + seatPlace +
                '}';
    }
}
