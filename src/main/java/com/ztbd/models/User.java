package com.ztbd.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @NotBlank
    @Column(unique = true, nullable = false, length = 255)
    private String username;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String password;

    @Column(length = 255)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private Role role;

    @Transient
    private boolean admin;


    @Email
    @NotBlank
    @Size(max = 254)
    @Column(name = "email", nullable = false, length = 254, unique = true)
    private String email;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return role.equals(Role.ADMIN);
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}