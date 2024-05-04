package com.CarRental.CarRentalPFA.Controllers;

import com.CarRental.CarRentalPFA.DTO.CarDTO;
import com.CarRental.CarRentalPFA.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/get")
    ResponseEntity<?> getAllCars(){
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @PostMapping("/add")
    ResponseEntity<?> AddCars(@RequestBody CarDTO car){
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @GetMapping("/update/{id}")
    ResponseEntity<?> getAllCars(@PathVariable("id") Long CarId){
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

}
