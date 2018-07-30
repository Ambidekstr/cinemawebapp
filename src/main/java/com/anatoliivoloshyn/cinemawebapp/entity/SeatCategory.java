package com.anatoliivoloshyn.cinemawebapp.entity;

public class SeatCategory {
    private long seatCategoryId;

    private Price price;

    private String seatCategory;

    public long getSeatCategoryId() {
        return seatCategoryId;
    }

    public void setSeatCategoryId(long seatCategoryId) {
        this.seatCategoryId = seatCategoryId;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }
}
