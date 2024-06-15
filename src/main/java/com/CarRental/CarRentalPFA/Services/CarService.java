package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
import com.CarRental.CarRentalPFA.DTO.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CarService {
    CarDTO getCar(Long Id);

    Page<CarDTO> getAllCarsByModel(String ModelName, Integer size, Integer page);

    Page<CarDTO> getAllCarsByStore(Long storeId, Integer size, Integer page);

    Page<CarDTO> getAllCarsByBody(CarBody carBody, Integer size, Integer page);

    Page<CarDTO> getAllCarsByBrand(Long brandId, Integer size, Integer page);

    CarDTO addCar(CarDTO car, String Username,Long Brand, MultipartFile attachment) throws IOException;
    CarDTO updateCar(CarDTO car);
    CarDTO updateCarAvailability(Long car);
    CarDTO deleteCar(Long carId);

    Page<CarDTO> getAllCarsByUser(String username, Integer size, Integer page);
}
