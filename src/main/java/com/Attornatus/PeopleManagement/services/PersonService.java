package com.Attornatus.PeopleManagement.services;

import com.Attornatus.PeopleManagement.models.Address;
import com.Attornatus.PeopleManagement.models.Person;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PersonService {

    public Person savePerson(Person person);
    public Person updatePerson(Person person);
    public Person findPersonById(UUID id);
    public List<Person> findPersonByName(String name);
    public List<Person> findPersonByPrincipalAddress(Address address);
    public List<Person> findAllPersons();
    public Person updatePersonAddress(UUID id, Address address, boolean principalAddress);
    public Set<Address> findPersonAddresses(UUID id);
    public Address findPrincipalAddres(UUID id);
    public void delete(Person person);
}
