package com.ztbd.models;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Hotel extends AbstractEntity {

    public Hotel() {
    }

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

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<User> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<User> employees) {
        this.employees = employees;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Hotel(String name, String city, String streetAndNumber, String postalCode, String phoneNumber) {
        this.name = name;
        this.city = city;
        this.streetAndNumber = streetAndNumber;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    }
}