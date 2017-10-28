package com.usedcardealer.dao;

import com.usedcardealer.model.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CarDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveCar(Car car) {
        entityManager.persist(car);
    }

    public void updateCar(Car car) {
        entityManager.merge(car);
    }
}
