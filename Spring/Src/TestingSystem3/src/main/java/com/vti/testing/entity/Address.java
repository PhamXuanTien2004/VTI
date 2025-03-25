package com.vti.testing.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String street;
    @Column(length = 50, nullable = false)
    private String city;
    @OneToMany(mappedBy = "address")
    private List<UserAddress> users;

    public List<UserAddress> getUsers() {
        return users;
    }

    public void setUsers(List<UserAddress> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
