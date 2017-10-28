package com.usedcardealer.services;

import com.usedcardealer.dao.CarDao;
import com.usedcardealer.dao.DealerDao;
import com.usedcardealer.model.Car;
import com.usedcardealer.model.Dealer;
import com.usedcardealer.repository.CarRepository;
import com.usedcardealer.repository.DealerRepository;
import com.usedcardealer.view.AddCarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarDao carDao;
    private DealerDao dealerDao;
    private DealerRepository dealerRepository;
    private CarRepository carRepository;

    @Autowired
    public CarService(CarDao carDao, DealerDao dealerDao, DealerRepository dealerRepository, CarRepository carRepository) {
        this.carDao = carDao;
        this.dealerDao = dealerDao;
        this.dealerRepository = dealerRepository;
        this.carRepository = carRepository;
    }

    public AddCarRequest addCar(AddCarRequest newCar) {
        Dealer dealer = dealerRepository.findOne(newCar.getDealerId());
        Car car = new Car();
        car.setCompany(newCar.getCompany());
        car.setModel(newCar.getModel());
        car.setEngineSize(newCar.getEngineSize());
        car.setType(newCar.getType());
        car.setReserved(newCar.isReserved());
        car.setDealer(dealer);
        dealer.getCarStock().add(car);
        carDao.saveCar(car);
        dealerDao.updateDealer(dealer);
        return newCar;
    }


    public void reserveCar(Integer id) {
        Car car = carRepository.findOne(id);
        if(car != null){
            car.setReserved(true);
            carDao.updateCar(car);
        }
    }
}
