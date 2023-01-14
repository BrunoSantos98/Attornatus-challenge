package com.Attornatus.PeopleManagement.services;

import com.Attornatus.PeopleManagement.models.Address;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

public interface AddressService {

    public Address saveAddress(Address address);
    public Address addressVerification(Address address);
    public Optional<Address> findAddressById(UUID id);
    public Address findAddress(Address address);
    public void delete(Address address);
}
