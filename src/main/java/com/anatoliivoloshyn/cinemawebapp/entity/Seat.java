package com.anatoliivoloshyn.cinemawebapp.entity;

public class Seat {
    private long seatId;

    private SeatCategory seatCategory;

    private int seatRow;
    private int seatPlace;

    public Seat() {
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
}
