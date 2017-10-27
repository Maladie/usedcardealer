package com.usedcardealer.controller;

import com.usedcardealer.model.Car;
import com.usedcardealer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    private CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @RequestMapping(value = "/getallcars", method = RequestMethod.GET)

    public List<Car> getAllCars() {
        List<Car> carsList = carRepository.findAll();
        return carsList;
    }
}
