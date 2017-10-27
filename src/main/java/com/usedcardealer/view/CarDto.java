package com.usedcardealer.view;


import com.usedcardealer.model.Car;

public class CarDto {

    private Integer id;
    private String company;
    private String model;
    private Integer engineSize;
    private String type;
    private boolean isReserved;
    private Integer dealerId;

    public CarDto(Car car, Integer dealerId) {
        this.id = car.getId();
        this.company = car.getCompany();
        this.model = car.getModel();
        this.engineSize = car.getEngineSize();
        this.type = car.getType();
        this.isReserved = car.isReserved();
        this.dealerId = dealerId;
    }
}
