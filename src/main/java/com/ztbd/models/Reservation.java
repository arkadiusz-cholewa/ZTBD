package com.ztbd.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Entity(name = "Reservation")
@Table(name = "reservations", indexes = {
        @Index(name = "idx_reservation_hotel_id", columnList = "hotel_id"),
        @Index(name = "idx_reservation_room_id", columnList = "room_id"),
        @Index(name = "idx_reservation_user_id", columnList = "usr_id")
})
public class Reservation extends AbstractEntity{
    public Reservation() {
    }

    @NotBlank
    @Size(max = 120)
    @Column(name = "reservation_number", nullable = false, length = 120)
    private String number;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @NotNull
    @Column(name = "date_from")
    private LocalDate dateFrom;

    @NotNull
    @Column(name = "date_to")
    private LocalDate dateTo;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id", nullable = false)
    private User user;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reservation(String number, Hotel hotel, Room room, User user) {
        this.number = number;
        this.hotel = hotel;
        this.room = room;
        this.user = user;
    }
}
