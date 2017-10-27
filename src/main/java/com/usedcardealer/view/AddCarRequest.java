package com.usedcardealer.view;


import com.usedcardealer.model.Car;

public class AddCarRequest {

    private Integer id;
    private String company;
    private String model;
    private Integer engineSize;
    private String type;
    private boolean isReserved;
    private Integer dealerId;

    AddCarRequest (){

    }

    public Integer getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public Integer getEngineSize() {
        return engineSize;
    }

    public String getType() {
        return type;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public Integer getDealerId() {
        return dealerId;
    }
}
