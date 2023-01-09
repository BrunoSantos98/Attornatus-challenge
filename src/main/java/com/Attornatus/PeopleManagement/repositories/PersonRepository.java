package com.Attornatus.PeopleManagement.repositories;

import com.Attornatus.PeopleManagement.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID>{
}
