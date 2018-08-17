package com.anatoliivoloshyn.cinemawebapp.entity;

import java.io.Serializable;
import java.util.Objects;

public class Ticket implements Serializable {
    private long ticketId;

    private Session session;

    private Order order;

    private Seat seat;

    private boolean booked;

    public Ticket() {

    }

    public Ticket(long ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(long ticketId, Session session, Seat seat, boolean booked) {
        this.ticketId = ticketId;
        this.session = session;
        this.seat = seat;
        this.booked = booked;
    }

    public Ticket(long ticketId, Session session, Order order, Seat seat, boolean booked) {

        this.ticketId = ticketId;
        this.session = session;
        this.order = order;
        this.seat = seat;
        this.booked = booked;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public boolean getBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketId == ticket.ticketId &&
                Objects.equals(session, ticket.session) &&
                Objects.equals(seat, ticket.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, session, seat);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", session=" + session +
                ", order=" + order +
                ", seat=" + seat +
                ", booked=" + booked +
                '}';
    }
}
