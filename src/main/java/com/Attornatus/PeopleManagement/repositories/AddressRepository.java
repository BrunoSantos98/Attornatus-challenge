package com.Attornatus.PeopleManagement.repositories;

import com.Attornatus.PeopleManagement.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID>{

    public Optional<Address> findByLogradouroAndCepAndNumberAndCity(String log, String cep, int number, String city);
}
