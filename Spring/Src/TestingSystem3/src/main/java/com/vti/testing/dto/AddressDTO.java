package com.vti.testing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDTO {
    private int id;
    private String street;
    private String city;
    @JsonProperty("username")
    private String userUsername;

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

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
}