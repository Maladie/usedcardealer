package com.usedcardealer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCarStock(Set<Car> carStock) {
        this.carStock = carStock;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Set<Car> getCarStock() {
        return carStock;
    }

    @NotNull
    @Embedded
    private Address address;
    @OneToMany
    private Set<Car> carStock = new HashSet<>();
}
