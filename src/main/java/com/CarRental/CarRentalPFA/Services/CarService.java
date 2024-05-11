package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
import com.CarRental.CarRentalPFA.DTO.CarDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarService {
    CarDTO getCar(Long Id);

    Page<CarDTO> getAllCarsByModel(String ModelName, Integer size, Integer page);

    Page<CarDTO> getAllCarsByStore(Long storeId, Integer size, Integer page);

    Page<CarDTO> getAllCarsByBody(CarBody carBody, Integer size, Integer page);

    Page<CarDTO> getAllCarsByBrand(Long brandId, Integer size, Integer page);

    CarDTO addCar(CarDTO car);
    CarDTO updateCar(CarDTO car);
    CarDTO deleteCar(Long carId);
}
