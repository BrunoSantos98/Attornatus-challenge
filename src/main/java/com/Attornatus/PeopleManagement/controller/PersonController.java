package com.Attornatus.PeopleManagement.controller;

import com.Attornatus.PeopleManagement.models.Address;
import com.Attornatus.PeopleManagement.models.Person;
import com.Attornatus.PeopleManagement.services.implementations.PersonServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*",maxAge = 3600)
public class PersonController {

    @Autowired
    PersonServiceImplementation personImp;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return ResponseEntity.ok(personImp.savePerson(person));
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        return ResponseEntity.ok(personImp.updatePerson(person));
    }

    @GetMapping("/findById")
    public ResponseEntity<Person> findPersonById(@RequestParam UUID id){
        return ResponseEntity.ok(personImp.findPersonById(id));
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Person>> findPersonByName(@RequestParam String name){
        return ResponseEntity.ok(personImp.findPersonByName(name));
    }

    @GetMapping("/findByPrincipalAddress")
    public ResponseEntity<List<Person>> findPersonByPricniaplAddress(@RequestParam UUID id){
        return ResponseEntity.ok(personImp.findPersonByPrincipalAddress(id));
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAllPersons(){
        return ResponseEntity.ok(personImp.findAllPersons());
    }

    @PatchMapping("/updatePersonAddress")
    public ResponseEntity<Person> updatepersonAddress(@RequestBody Address address, @RequestParam UUID id,
                                                      @RequestParam boolean principalAddress){
        return ResponseEntity.ok(personImp.updatePersonAddress(id,address,principalAddress));
    }

    @GetMapping("/getAllPersonAddresses")
    public ResponseEntity<Set<Address>> getAllPersonAddress(@RequestParam UUID id){
        return ResponseEntity.ok(personImp.findPersonAddresses(id));
    }

    @GetMapping("/findPersonPrincipalAddress")
    public ResponseEntity<Address> findPersonPrincipalAddress(@RequestParam UUID id){
        return ResponseEntity.ok(personImp.findPrincipalAddres(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePerson(@RequestParam UUID id){
        personImp.delete(personImp.findPersonById(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Person deletado com sucesso");
    }
}
