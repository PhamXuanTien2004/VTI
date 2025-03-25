package com.vti.testing.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @OneToMany(mappedBy = "user")
    private List<UserAddress> userAddresses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;
    }
}