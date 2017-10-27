package com.usedcardealer.repository;

import com.usedcardealer.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByDealer(String dealerName);
    List<Car> findByCompany(String companyName);
    List<Car> findByCompanyAndModel(String companyName, String modelName);
}
