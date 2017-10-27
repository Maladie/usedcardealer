package com.usedcardealer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    @Embedded
    private Address address;
}
