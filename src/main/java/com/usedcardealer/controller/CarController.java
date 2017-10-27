package com.usedcardealer.controller;

import com.usedcardealer.dao.CarDao;
import com.usedcardealer.model.Car;
import com.usedcardealer.model.Dealer;
import com.usedcardealer.repository.CarRepository;
import com.usedcardealer.services.CarService;
import com.usedcardealer.view.AddCarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CarController {

    private CarRepository carRepository;
    private CarService carService;

    @Autowired
    public CarController(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @RequestMapping(value = "/getAllCars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        List<Car> carsList = carRepository.findAll();
        return carsList;
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public ResponseEntity<Car> addCar(@RequestBody @Valid AddCarRequest newCar, BindingResult result) {
        Car car = carService.addCar(newCar);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }



}
