package com.usedcardealer.controller;

import com.usedcardealer.dao.CarDao;
import com.usedcardealer.model.Car;
import com.usedcardealer.model.Dealer;
import com.usedcardealer.repository.CarRepository;
import com.usedcardealer.services.CarService;
import com.usedcardealer.view.AddCarRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> carsList = carRepository.findAll();
        return new ResponseEntity<List<Car>>(carsList,HttpStatus.OK);
    }

    @RequestMapping(value = "/getCarsByCompany", method = RequestMethod.GET)
    public List<Car> getCarsByCompany(@RequestParam(value = "companyName") String companyName) {
        List<Car> carsList2 = carRepository.findByCompany(companyName);
        return carsList2;
    }

    @RequestMapping(value = "/getCarsByDealer", method = RequestMethod.GET)
    public List<Car> getCarsByDealer(@RequestParam String dealerName) {
        List<Car> carsByDealer = carRepository.findByDealer(dealerName);
        return carsByDealer;
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public ResponseEntity<AddCarRequest> addCar(@RequestBody @Valid AddCarRequest newCar, BindingResult result) {
        AddCarRequest addedCar = carService.addCar(newCar);
        return new ResponseEntity<>(addedCar, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getCarsByCompanyAndModel", method = RequestMethod.GET)
    public List<Car> getCarsByCompanyAndModel(@RequestParam(value = "companyName") String companyName,
                                              @RequestParam(value = "modelName") String modelName) {
        List<Car> carsList3 = carRepository.findByCompanyAndModel(companyName, modelName);
        return carsList3;
    }
    @RequestMapping(value = "/getCar/{id}", method = RequestMethod.GET)
    public boolean checkCarAvailability(@PathVariable(value = "id") Integer id) {
        Car car = carRepository.findByIdAndIsReserved(id, false);
        if(car != null) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/getCarById/{id}", method = RequestMethod.GET)
    public Car getCarById(@PathVariable(value = "id") Integer id) {
        return carRepository.findOne(id);
    }
}
