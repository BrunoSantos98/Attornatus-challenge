package com.Attornatus.PeopleManagement.services;

import com.Attornatus.PeopleManagement.models.Address;
import org.springframework.stereotype.Service;

public interface AddressService {

    public Address saveAddress(Address address);
    public Address addressVerification(Address address);
    public Address findAddress(Address address);
    public void delete(Address address);
}
