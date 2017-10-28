package com.usedcardealer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dealer_id")
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    @Embedded
    private Address address;
    @JsonIgnore
    @OneToMany(mappedBy = "dealer")
    private Set<Car> carStock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Car> getCarStock() {
        return carStock;
    }

    public void setCarStock(Set<Car> carStock) {
        this.carStock = carStock;
    }
}
