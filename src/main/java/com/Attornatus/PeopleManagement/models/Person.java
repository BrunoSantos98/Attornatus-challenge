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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="dd/MM/yyyy")
    private Date birthDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Set<Address> personAddress = new HashSet<>();
    @OneToOne
    @JoinColumn(name = "principal_address_id")
    private  Address principalAddress;

}
