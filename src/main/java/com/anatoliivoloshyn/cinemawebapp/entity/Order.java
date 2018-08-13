package com.anatoliivoloshyn.cinemawebapp.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Order implements Serializable {
    private long ordersId;

    private Timestamp ordersDateTime;

    private User user;

    public Order() {

    }

    public Order(long ordersId) {
        this.ordersId = ordersId;
    }

    public Order(long ordersId, Timestamp ordersDateTime, User user) {
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

    public Timestamp getOrdersDateTime() {
        return ordersDateTime;
    }

    public void setOrdersDateTime(Timestamp ordersDateTime) {
        this.ordersDateTime = ordersDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return ordersId == order.ordersId &&
                Objects.equals(ordersDateTime, order.ordersDateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ordersId, ordersDateTime);
    }

    @Override
    public String toString() {
        return "Order{" +
                "ordersId=" + ordersId +
                ", ordersDateTime=" + ordersDateTime +
                ", user=" + user +
                '}';
    }
}
