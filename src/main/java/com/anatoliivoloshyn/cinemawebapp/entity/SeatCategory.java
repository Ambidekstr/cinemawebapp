package com.anatoliivoloshyn.cinemawebapp.entity;

import java.math.BigDecimal;

public class SeatCategory {
    private long seatCategoryId;

    private BigDecimal price;

    private String seatCategory;

    public long getSeatCategoryId() {
        return seatCategoryId;
    }

    public void setSeatCategoryId(long seatCategoryId) {
        this.seatCategoryId = seatCategoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }
}
