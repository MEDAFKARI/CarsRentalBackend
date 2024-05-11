package com.CarRental.CarRentalPFA.Mappers;
import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Repositories.BrandRepository;
import com.CarRental.CarRentalPFA.DAO.Repositories.StoreRepository;
import com.CarRental.CarRentalPFA.DTO.CarDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    StoreRepository storeRepository;


    public CarDTO convertToCarDTO(Car car){
        CarDTO carDTO = modelMapper.map(car, CarDTO.class);
      return carDTO;
    }


    public Car convertToCar(CarDTO carDTO){
        Car car = modelMapper.map(carDTO, Car.class);
        return car;
    }




}
