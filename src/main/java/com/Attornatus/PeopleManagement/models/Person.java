package com.Attornatus.PeopleManagement.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_PERSON")
public class Person implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID personId;
    private String name;
    @JsonFormat(pattern ="dd/MM/yyyy")
    private Date birthDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_person_id")
    private Set<Address> personAddress = new HashSet<>();
    private  UUID principalAddressId;

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Address> getPersonAddress() {
        return personAddress;
    }

    public UUID getPrincipalAddressId() {
        return principalAddressId;
    }

    public void setPrincipalAddressId(UUID principalAddressId) {
        this.principalAddressId = principalAddressId;
    }
}
