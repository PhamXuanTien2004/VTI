package com.vti.testing.service;

import com.vti.testing.entity.Address;

import java.util.List;

public interface IAddressService {
    Address getAddressById(int id);
    List<Address> getAllAddresses();
}
