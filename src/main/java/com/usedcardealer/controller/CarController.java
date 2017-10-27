package com.usedcardealer.controller;

import com.usedcardealer.dao.CarDao;
import com.usedcardealer.model.Car;
import com.usedcardealer.model.Dealer;
import com.usedcardealer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(value = "/getAllCars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        List<Car> carsList = carRepository.findAll();
        return carsList;
    }

    @RequestMapping(value = "/getCarsByCompany", method = RequestMethod.GET)
    public List<Car> getCarsByCompany(@RequestParam(value = "companyName") String companyName) {
        List<Car> carsList2 = carRepository.findByCompany(companyName);
        return carsList2;
    }

    @RequestMapping(value = "getCarsByCompanyAndModel", method = RequestMethod.GET)
    public List<Car> getCarsByCompanyAndModel(@RequestParam(value = "companyName") String companyName,
                                              @RequestParam(value = "modelName") String modelName) {
        List<Car> carsList3 = carRepository.findByCompanyAndModel(companyName, modelName);
        return carsList3;
    }
}
