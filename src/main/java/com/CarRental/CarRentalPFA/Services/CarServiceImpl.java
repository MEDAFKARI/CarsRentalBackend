package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Repositories.CarRepository;
import com.CarRental.CarRentalPFA.DTO.CarDTO;
import com.CarRental.CarRentalPFA.Mappers.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;
    @Autowired
    CarMapper carMapper;

    @Override
    public List<CarDTO> getAllCars() {

        return carRepository.findAll().stream()
                .map(car -> carMapper.convertToCarDTO(car)).collect(Collectors.toList());
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
    public CarDTO addCar(CarDTO car) {
        CarDTO carDTO = carMapper
                .convertToCarDTO(
                        carRepository.save(
                                carMapper.convertToCar(car)));

        return carDTO;
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
