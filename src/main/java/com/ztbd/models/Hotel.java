package com.ztbd.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Hotel")
@Table(name = "hotels")
public class Hotel extends AbstractEntity {

    @NotBlank
    @Column(unique = true, nullable = false, length = 255)
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Room> rooms = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}