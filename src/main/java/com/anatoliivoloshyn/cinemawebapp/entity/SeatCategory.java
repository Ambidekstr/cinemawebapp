package com.anatoliivoloshyn.cinemawebapp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class SeatCategory implements Serializable {
    private long seatCategoryId;

    private BigDecimal price;

    public SeatCategory() {

    }

    public SeatCategory(long seatCategoryId, BigDecimal price, String seatCategory) {
        this.seatCategoryId = seatCategoryId;
        this.price = price;
        this.seatCategory = seatCategory;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatCategory that = (SeatCategory) o;
        return seatCategoryId == that.seatCategoryId &&
                Objects.equals(price, that.price) &&
                Objects.equals(seatCategory, that.seatCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatCategoryId, price, seatCategory);
    }

    @Override
    public String toString() {
        return "SeatCategory{" +
                "seatCategoryId=" + seatCategoryId +
                ", price=" + price +
                ", seatCategory='" + seatCategory + '\'' +
                '}';
    }
}
