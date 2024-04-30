package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    List<Car> getAllCarsByStore(Long storeId);
    List<Car> getAllCarsByBrand(Long brandId);
    Car addCar(Car car);
    Car updateCar(Car car);
    Car deleteCar(Long carId);
}
