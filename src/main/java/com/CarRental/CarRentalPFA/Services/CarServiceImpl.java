package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {

        return carRepository.findAll();
    }

    public List<Car> getAllCarsByModel(String ModelName) {

        return carRepository.findAllByCarModelContaining(ModelName);
    }

    @Override
    public List<Car> getAllCarsByStore(Long storeId) {

        return carRepository.findAllByStoreId(storeId);
    }

    @Override
    public List<Car> getAllCarsByBrand(Long brandId) {

        return carRepository.findAllByBrandId(brandId);
    }

    @Override
    public Car addCar(Car car) {

        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car deleteCar(Long carId) {
        Car car = carRepository.findById(carId).get();
        carRepository.delete(car);
        return car;
    }
}
