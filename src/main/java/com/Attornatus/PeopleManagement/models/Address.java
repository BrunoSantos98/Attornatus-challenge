package com.Attornatus.PeopleManagement.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ADDRESS")
public class Address implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID addressId;
    @Column(nullable = false,length = 120)
    private String logradouro;
    @Column(nullable = false,length = 10)
    private String cep;
    @Column(nullable = false,length = 8)
    private Integer number;
    @Column(nullable = false,length = 40)
    private String  city;

    public Address() {
    }

    public Address(UUID addressId, String logradouro, String cep, Integer number, String city) {
        this.addressId = addressId;
        this.logradouro = logradouro;
        this.cep = cep;
        this.number = number;
        this.city = city;
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
