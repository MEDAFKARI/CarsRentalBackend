package com.CarRental.CarRentalPFA;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;
import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DAO.Entities.User;
import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
import com.CarRental.CarRentalPFA.DAO.Enum.Fuel;
import com.CarRental.CarRentalPFA.DAO.Enum.Role;
import com.CarRental.CarRentalPFA.DAO.Enum.Transmission;
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
	StoreService storeService;
	@Autowired
	BrandService brandService;
	@Autowired
	CarService carService;

	public static void main(String[] args) {
		SpringApplication.run(CarRentalPfaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null,"med","med@test","1234", Role.USER,null,null,null);
		userRepository.save(user1);
		Store store1 = new Store(null,"Testing",null,null,null,user1,null);
		storeService.addStore(store1);
		user1.setStore(store1);
		userRepository.save(user1);
		CarBrand carBrand = new CarBrand(null,"Renault","",null);
		brandService.addBrand(carBrand);
		Car car = new Car(null,"clio 4",200D,null, CarBody.HATCHBACK,4, Transmission.MANUAL, Fuel.DIESEL,null,store1,null);
		carService.addCar(car);
		carBrand.setCars(List.of(car));
		store1.setCars(List.of(car));
		brandService.updateBrand(carBrand);
		storeService.updateStore(store1);

	}
}
