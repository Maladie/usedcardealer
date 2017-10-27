package com.usedcardealer.repository;

import com.usedcardealer.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllCars();
    List<Car> findCarsByDealer(String dealerName);
    List<Car> findCarsByCompany(String companyName);
    List<Car> findCarsByCompanyAndModel(String companyName, String modelName);
}
