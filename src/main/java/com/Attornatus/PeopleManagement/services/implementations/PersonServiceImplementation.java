package com.Attornatus.PeopleManagement.services.implementations;

import com.Attornatus.PeopleManagement.models.Address;
import com.Attornatus.PeopleManagement.models.Person;
import com.Attornatus.PeopleManagement.repositories.PersonRepository;
import com.Attornatus.PeopleManagement.services.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonServiceImplementation implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressServiceImplementation addrImp;

    @Override
    public Person savePerson(Person person){
        Iterator<Address> iterator = person.getPersonAddress().iterator();
        Address personAddress = null;


        personAddress = addrImp.saveAddress(iterator.next());
        person.getPersonAddress().add(personAddress);
        person.setPrincipalAddressId(personAddress.getAddressId());
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        Person oldDataPerson = findPersonById(person.getPersonId());
        BeanUtils.copyProperties(person,oldDataPerson);
        savePerson(oldDataPerson);
        return oldDataPerson;
    }

    @Override
    public Person findPersonById(UUID id) {
        return personRepository.findById(id).get();
    }

    @Override
    public List<Person> findPersonByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    public List<Person> findPersonByPrincipalAddress(Address address) {
        address = addrImp.findAddress(address);
        return personRepository.findByPrincipalAddressId(address.getAddressId());
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person updatePersonAddress(UUID id, Address address, boolean principalAddress) {
        Person person = findPersonById(id);
        if(principalAddress){
            address = addrImp.saveAddress(address);
            person.setPrincipalAddressId(address.getAddressId());
            person.getPersonAddress().add(address);
            savePerson(person);
            return person;
        }else{
            person.getPersonAddress().add(address);
            savePerson(person);
            return person;
        }
    }

    @Override
    public Set<Address> findPersonAddresses(UUID id) {
        Person person = findPersonById(id);
        return person.getPersonAddress();
    }

    @Override
    public Address findPrincipalAddres(UUID id) {
        Person person = findPersonById(id);
        UUID addressId = person.getPrincipalAddressId();
        Address address = (Address) person.getPersonAddress().stream().filter(addr -> addr.getAddressId().equals(addressId));
        return address;
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }
}
