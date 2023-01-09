package com.Attornatus.PeopleManagement.repositories;

import com.Attornatus.PeopleManagement.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID>{

    public Optional<Address> findByLogradouroAndCepAndNumberAndCity(String log, int cep, int number, String city);
}
