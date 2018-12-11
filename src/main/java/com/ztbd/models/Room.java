package com.ztbd.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Room")
@Table(name = "rooms")
public class Room extends AbstractEntity {

    @NotBlank
    @Column(nullable = false, length = 255)
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}