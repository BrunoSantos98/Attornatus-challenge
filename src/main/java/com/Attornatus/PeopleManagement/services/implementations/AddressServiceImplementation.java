package com.Attornatus.PeopleManagement.services.implementations;

import com.Attornatus.PeopleManagement.models.Address;
import com.Attornatus.PeopleManagement.repositories.AddressRepository;
import com.Attornatus.PeopleManagement.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImplementation implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        address = addressVerification(address);
        return address;
    }

    @Override
    public Address addressVerification(Address address) {
        Optional<Address> addressVerification = addressRepository.findByLogradouroAndCepAndNumberAndCity(
                address.getLogradouro(),address.getCep(),address.getNumber(),address.getCity());
        if(addressVerification.isEmpty()){
            address = addressRepository.save(address);
        }else{
            address = addressVerification.get();
        }
        return address;
    }

    @Override
    public Address findAddress(Address address) {
        return addressRepository.findByLogradouroAndCepAndNumberAndCity(address.getLogradouro(),address.getCep(),
                address.getNumber(),address.getCity()).get();
    }

    @Override
    public void delete(Address address) {
        addressRepository.delete(address);
    }
}
