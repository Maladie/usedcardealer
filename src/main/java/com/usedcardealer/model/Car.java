package com.usedcardealer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String company;
    @NotNull
    private String model;
    @NotNull
    private Integer engineSize;
    @NotNull
    private String type;
    @NotNull
    private boolean isReserved;
    @ManyToOne
    private Dealer dealer;


}
