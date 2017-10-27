package com.usedcardealer.controller;

import com.usedcardealer.dao.CarDao;
import com.usedcardealer.model.Car;
import com.usedcardealer.model.Dealer;
import com.usedcardealer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CarController {

    private CarRepository carRepository;
    private CarDao carDao;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @RequestMapping(value = "/getallcars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        List<Car> carsList = carRepository.findAll();
        return carsList;
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public ResponseEntity<Car> addCar(@RequestBody @Valid Car car,
                                      @RequestParam("dealer") @Valid Integer dealerId) {
        return new ResponseEntity<Car>(car, HttpStatus.CREATED);
    }



}
