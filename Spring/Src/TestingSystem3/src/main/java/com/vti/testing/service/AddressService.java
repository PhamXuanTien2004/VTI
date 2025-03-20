package com.vti.testing.service;

import com.vti.testing.entity.Address;
import com.vti.testing.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService implements IAddressService{
    @Autowired
    private IAddressRepository addressRepository ;
    @Override
    public Address getAddressById(int id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
