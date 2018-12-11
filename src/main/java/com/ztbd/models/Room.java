package com.ztbd.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name = "Room")
@Table(name = "rooms", indexes = {
        @Index(name = "idx_room_amount_od_people", columnList = "amount_of_people"),
        @Index(name = "idx_room_hotel_id", columnList = "hotel_id"),
        @Index(name = "idx_price_per_day", columnList = "price_per_day")})
public class Room extends AbstractEntity {

    @NotBlank
    @NotNull
    @Column(name = "room_number", nullable = false, length = 20)
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @DecimalMin("0.0")
    @DecimalMax("99999999999999999.99")
    @Column(name = "price_per_day", nullable = true)
    private BigDecimal pricePerDay;

    @NotNull
    @Column(name = "amount_of_people")
    private Integer amountOfPeople;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "room_state", nullable = false)
    private RoomState state;

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

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Integer getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(Integer amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public RoomState getState() {
        return state;
    }

    public void setState(RoomState state) {
        this.state = state;
    }

    public Room(String number, Hotel hotel, BigDecimal pricePerDay, Integer amountOfPeople, RoomState state) {
        this.number = number;
        this.hotel = hotel;
        this.pricePerDay = pricePerDay;
        this.amountOfPeople = amountOfPeople;
        this.state = state;
    }
}