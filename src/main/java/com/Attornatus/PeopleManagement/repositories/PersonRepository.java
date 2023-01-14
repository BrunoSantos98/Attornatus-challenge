package com.Attornatus.PeopleManagement.repositories;

import com.Attornatus.PeopleManagement.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID>{

    public List<Person> findByName(String name);
    public List<Person> findByPrincipalAddressId(UUID id);
}
