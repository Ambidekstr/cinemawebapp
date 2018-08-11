package com.anatoliivoloshyn.cinemawebapp.entity;

import java.util.Date;
import java.util.List;

public class Order {
    private long ordersId;

    private Date ordersDateTime;

    private User user;

    public Order() {

    }

    public Order(long ordersId, Date ordersDateTime, User user) {
        this.ordersId = ordersId;
        this.ordersDateTime = ordersDateTime;
        this.user = user;
    }

    public long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(long ordersId) {
        this.ordersId = ordersId;
    }

    public Date getOrdersDateTime() {
        return ordersDateTime;
    }

    public void setOrdersDateTime(Date ordersDateTime) {
        this.ordersDateTime = ordersDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}