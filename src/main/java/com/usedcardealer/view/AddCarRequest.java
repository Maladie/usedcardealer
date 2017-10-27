package com.usedcardealer.view;


public class AddCarRequest {

    private String company;
    private String model;
    private Integer engineSize;
    private String type;
    private boolean isReserved;
    private Integer dealerId;

    AddCarRequest() {
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
