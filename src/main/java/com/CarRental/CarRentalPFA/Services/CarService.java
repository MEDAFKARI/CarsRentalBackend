package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DTO.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getAllCars();
    List<Car> getAllCarsByStore(Long storeId);
    List<Car> getAllCarsByBrand(Long brandId);
    CarDTO addCar(CarDTO car);
    Car updateCar(Car car);
    Car deleteCar(Long carId);
}
