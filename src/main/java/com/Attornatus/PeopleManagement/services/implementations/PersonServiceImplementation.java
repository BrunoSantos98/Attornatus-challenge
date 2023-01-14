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
        Address personAddress = addrImp.saveAddress(iterator.next());
        person.getPersonAddress().clear();
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
    public List<Person> findPersonByPrincipalAddress(UUID id) {
        return personRepository.findByPrincipalAddressId(id);
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person updatePersonAddress(UUID id, Address address, boolean principalAddress) {
        address = addrImp.saveAddress(address);
        Person person = findPersonById(id);
        person.getPersonAddress().add(address);
        if(principalAddress){
            person.setPrincipalAddressId(address.getAddressId());
        }
        savePerson(person);
        return person;
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
        Optional<Address> address = addrImp.findAddressById(addressId);
        return address.get();
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }
}
