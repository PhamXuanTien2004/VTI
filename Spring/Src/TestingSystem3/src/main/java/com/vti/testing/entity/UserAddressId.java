package com.vti.testing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserAddressId {
    @Column (name = "user_id", nullable = false)
    private int id;
    @Column (name = "address_id", nullable = false)
    private int addressId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
