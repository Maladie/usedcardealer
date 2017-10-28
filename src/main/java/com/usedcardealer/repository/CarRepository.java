package com.usedcardealer.repository;

import com.usedcardealer.model.Car;
import com.usedcardealer.view.CarDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByDealer(String dealerName);
    List<Car> findByCompany(String companyName);
    List<Car> findByCompanyAndModel(String companyName, String modelName);
    Car findByIdAndIsReserved(Integer id, boolean isReserved);
    Car findById(Integer id);
}
