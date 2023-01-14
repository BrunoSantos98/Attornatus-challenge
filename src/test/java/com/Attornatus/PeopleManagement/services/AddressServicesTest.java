package com.Attornatus.PeopleManagement.services;

import com.Attornatus.PeopleManagement.models.Address;
import com.Attornatus.PeopleManagement.services.implementations.AddressServiceImplementation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServicesTest {
    @Autowired
    AddressServiceImplementation addrImp;

    Address address = new Address("Pracinha jesus", "00100100",14,"Sao Paulo");

    @Test
    public void shouldBeSaveANewAddress(){
        assertEquals(addrImp.saveAddress(address),address);
    }

    @Test
    public void shouldBeEqualAddress(){
        Address address02 = addrImp.saveAddress(address);
        assertEquals(address02.getAddressId(),address.getAddressId());
    }

    @Test
    public void findAddressByIdTest(){
        Address address02 = addrImp.saveAddress(address);
        assertEquals(addrImp.findAddressById(address02.getAddressId()).get().getCep(),address.getCep());
        assertEquals(addrImp.findAddressById(address02.getAddressId()).get().getCity(),address.getCity());
        assertEquals(addrImp.findAddressById(address02.getAddressId()).get().getCity(),address.getCity());
        assertEquals(addrImp.findAddressById(address02.getAddressId()).get().getLogradouro(),address.getLogradouro());
    }

    @Test
    public void findAddressByAddressInformations(){
        Address addressInformations = addrImp.saveAddress(address);
        Address address02 = addrImp.findAddress(addressInformations);
        assertEquals(address02.getAddressId(),address.getAddressId());
    }

    @Test
    public void shouldBeDeleteAddress(){
        addrImp.saveAddress(address);
        UUID addressId = address.getAddressId();
        addrImp.delete(address);
        Address address02 = null;
        if(addrImp.findAddressById(addressId).isPresent()){
            address02 = addrImp.findAddressById(addressId).get();
        }
        assertNull(address02);
    }
}
