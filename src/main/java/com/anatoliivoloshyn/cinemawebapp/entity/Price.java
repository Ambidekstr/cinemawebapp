package com.anatoliivoloshyn.cinemawebapp.entity;

import java.math.BigDecimal;

public class Price {
    private long priceId;

    private BigDecimal price;

    public long getPriceId() {
        return priceId;
    }

    public void setPriceId(long priceId) {
        this.priceId = priceId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
