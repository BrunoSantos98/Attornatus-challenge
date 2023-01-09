package com.Attornatus.PeopleManagement.services;

import com.Attornatus.PeopleManagement.models.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    public Address saveAddress(Address address);
    public Address addressVerification(Address address);
    public void delete(AddressService address);
}
