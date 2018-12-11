package com.ztbd.models;



import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Hotel")
@Table(name = "hotels",  indexes = {
        @Index(name = "idx_hotel_name", columnList = "name"),
        @Index(name = "idx_city", columnList = "city"),
        @Index(name = "idx_street_and_number", columnList = "street_and_number"),
        @Index(name = "idx_postal_code", columnList = "postal_code")
})
public class Hotel extends AbstractEntity {

    @NotBlank
    @Column(unique = true, nullable = false, length = 255)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "hotel")
    private Set<Room> rooms = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "hotel_employees",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            indexes = @Index(name = "idx_hotel_employees_id", columnList = "hotel_id"))
    private Set<User> employees;

    @NotBlank
    @Size(max = 120)
    @Column(name = "city", nullable = false, length = 120)
    private String city;

    @NotBlank
    @Size(max = 255)
    @Column(name = "street_and_number", nullable = false, length = 255)
    private String streetAndNumber;

    @NotBlank
    @Size(max = 10)
    @Column(name = "postal_code", nullable = false, length = 10)
    private String postalCode;

    @Size(max = 40)
    @Column(name = "phone_number", nullable = true, length = 40)
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}