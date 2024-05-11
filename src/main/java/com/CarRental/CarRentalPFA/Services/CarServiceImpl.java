package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
import com.CarRental.CarRentalPFA.DAO.Repositories.CarRepository;
import com.CarRental.CarRentalPFA.DTO.CarDTO;
import com.CarRental.CarRentalPFA.Mappers.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public CarDTO getCar(Long Id) {
        return carMapper.convertToCarDTO(carRepository.findById(Id).get());
    }

    @Override
    public Page<CarDTO> getAllCarsByModel(String ModelName, Integer size, Integer page) {

        return carRepository.findAllByCarModelContaining(ModelName,PageRequest.of(page,size)).map(car -> carMapper.convertToCarDTO(car));
    }

    @Override
    public Page<CarDTO> getAllCarsByStore(Long storeId, Integer size, Integer page) {
        Page<Car> cars= carRepository.findAllByStoreId(storeId, PageRequest.of(page,size));
        Page<CarDTO> carDTOS = cars
                .map(car -> carMapper.convertToCarDTO(car));
        return carDTOS;
    }

    @Override
    public Page<CarDTO> getAllCarsByBody(CarBody carBody, Integer size, Integer page) {
        Page<CarDTO> carDTOS= carRepository.findAllByBody(carBody,PageRequest.of(page,size))
                .map(car -> carMapper.convertToCarDTO(car));
        return carDTOS;
    }

    @Override
    public Page<CarDTO> getAllCarsByBrand(Long brandId, Integer size, Integer page) {

        Page<CarDTO> carDTOS =
                carRepository.findAllByBrandId(brandId,PageRequest.of(page,size))
                .map(car -> carMapper.convertToCarDTO(car));
        return carDTOS;
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
    public CarDTO updateCar(CarDTO car) {
        Car car1=carRepository.save(carMapper.convertToCar(car));
        return carMapper.convertToCarDTO(car1);
    }

    @Override
    public CarDTO deleteCar(Long carId) {
        Car car = carRepository.findById(carId).get();
        carRepository.delete(car);
        return carMapper.convertToCarDTO(car);
    }
}
