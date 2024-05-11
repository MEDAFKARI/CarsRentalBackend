package com.CarRental.CarRentalPFA;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;
import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DAO.Entities.User;
import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
import com.CarRental.CarRentalPFA.DAO.Enum.Fuel;
import com.CarRental.CarRentalPFA.DAO.Enum.Role;
import com.CarRental.CarRentalPFA.DAO.Enum.Transmission;
import com.CarRental.CarRentalPFA.DAO.Repositories.BrandRepository;
import com.CarRental.CarRentalPFA.DAO.Repositories.CarRepository;
import com.CarRental.CarRentalPFA.DAO.Repositories.StoreRepository;
import com.CarRental.CarRentalPFA.DAO.Repositories.UserRepository;
import com.CarRental.CarRentalPFA.Services.BrandService;
import com.CarRental.CarRentalPFA.Services.CarService;
import com.CarRental.CarRentalPFA.Services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CarRentalPfaApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;

	@Autowired
	StoreRepository storeRepository;
	@Autowired
	BrandRepository brandRepository;
	@Autowired
	CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarRentalPfaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user1 = new User(	"med","med@test","1234", Role.USER,null,null,null);
//		userRepository.save(user1);
//		Store store1 = new Store(null,"Testing",null,null,null,user1,null);
//		storeRepository.save(store1);
//		user1.setStore(store1);
//		userRepository.save(user1);
//		CarBrand carBrand = new CarBrand(null,"Renault","",null);
//		brandRepository.save(carBrand);
//		Car car = new Car(null,"clio 4",200D,carBrand, CarBody.HATCHBACK,4, Transmission.MANUAL, Fuel.DIESEL,null,store1,null);
//		carRepository.save(car);
//		store1.setCars(List.of(car));
//		storeRepository.save(store1);

//		Car car = new Car(null,"SUV",200D,null, CarBody.SUV,4, Transmission.MANUAL, false,Fuel.DIESEL,null,null,null);
//		carRepository.save(car);

	}
}
