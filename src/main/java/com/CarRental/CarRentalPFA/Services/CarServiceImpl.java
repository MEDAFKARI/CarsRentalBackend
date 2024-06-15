package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
import com.CarRental.CarRentalPFA.DAO.Repositories.CarRepository;
import com.CarRental.CarRentalPFA.DAO.Repositories.UserRepository;
import com.CarRental.CarRentalPFA.DTO.BrandDTO;
import com.CarRental.CarRentalPFA.DTO.CarDTO;
import com.CarRental.CarRentalPFA.Mappers.BrandMapper;
import com.CarRental.CarRentalPFA.Mappers.CarMapper;
import com.CarRental.CarRentalPFA.Mappers.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Host
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;
    @Autowired
    CarMapper carMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    StoreMapper storeMapper;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    BrandService brandService;

    @Override
    public CarDTO getCar(Long Id) {
        return carMapper.convertToCarDTO(carRepository.findById(Id).get());
    }

    @Override
    public Page<CarDTO> getAllCarsByModel(String ModelName, Integer size, Integer page) {

        return carRepository.findAllByCarModelContaining(ModelName,PageRequest.of(page,size)).map(car -> carMapper.convertToCarDTO(car));
    }

    @Override
    public Page<CarDTO> getAllCarsByUser(String username, Integer size, Integer page) {
        Page<Car> cars= carRepository.findAllByStoreId(userRepository.findById(username).get().getStore().getId(), PageRequest.of(page,size));
        Page<CarDTO> carDTOS = cars
                .map(car -> carMapper.convertToCarDTO(car));
        System.out.println(carDTOS);
        return carDTOS;
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

    public String uploadfile(MultipartFile file) throws IOException {
        String filePATH = Host.LOCAL + file.getOriginalFilename(); // saved path locally
        String fileUrl = Host.HOSTNAME + file.getOriginalFilename();
        Files.write(Paths.get(filePATH),file.getBytes());
        return fileUrl;
    }

    @Override
    public CarDTO addCar(CarDTO car, String Username,Long Brand, MultipartFile file) throws IOException {
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");

        System.out.println("-------------------------------------------------");

        car.setStore(storeMapper.convertStoreToStoreDTO(userRepository.findById(Username).get().getStore()));
        car.setBrand(brandService.getBrand(Brand));
        car.setCarImage(uploadfile(file));
        System.out.println(car);
        CarDTO carDTO = carMapper
                .convertToCarDTO(
                        carRepository.save(
                                carMapper.convertToCar(car)));

        return carDTO;
    }

    @Override
    public CarDTO updateCar(CarDTO car) {
        Car car2 = carRepository.findById(car.getId()).get();
        car.setCarImage(car2.getCarImage());
        car.setStore(storeMapper.convertStoreToStoreDTO(car2.getStore()));
        car.setAvailability(car2.getAvailability());
        car.setBrand(brandMapper.convertToDTO(car2.getBrand()));
        Car car1=carRepository.save(carMapper.convertToCar(car));
        return carMapper.convertToCarDTO(car1);
    }

    @Override
    public CarDTO updateCarAvailability(Long car) {
        Car car1=carRepository.findById(car).get();
        System.out.println("---------------------------------");
        System.out.println("----------------------AVAILABLE");
        System.out.println(car1.getAvailability());
        System.out.println(!car1.getAvailability());
        car1.setAvailability(!car1.getAvailability());
        return carMapper.convertToCarDTO(carRepository.save(car1));
    }

    @Override
    public CarDTO deleteCar(Long carId) {
        Car car = carRepository.findById(carId).get();
        carRepository.delete(car);
        return carMapper.convertToCarDTO(car);
    }


}
