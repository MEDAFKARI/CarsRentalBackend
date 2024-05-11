package com.CarRental.CarRentalPFA.Controllers;

import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
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
    ResponseEntity<?> getAllCars(@RequestParam(value = "search", defaultValue = "") String kw,
                                 @RequestParam(value = "size", defaultValue = "5") Integer size,
                                 @RequestParam(value = "page", defaultValue = "0") Integer page){

        return new ResponseEntity<>(carService.getAllCarsByModel(kw, size, page), HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    ResponseEntity<?> getCar(@PathVariable("id") Long carID){
        return new ResponseEntity<>(carService.getCar(carID), HttpStatus.OK);
    }

    @GetMapping("/getByStore/{id}")
    ResponseEntity<?> getCarsByStore(@PathVariable("id") Long storeId,
                                     @RequestParam(value = "size", defaultValue = "5") Integer size,
                                     @RequestParam(value = "page", defaultValue = "0") Integer page){
        return new ResponseEntity<>(carService.getAllCarsByStore(storeId,size,page), HttpStatus.OK);
    }

    @GetMapping("/getByBrand/{id}")
    ResponseEntity<?> getCarsByBrand(@PathVariable("id") Long brandId,
                                     @RequestParam(value = "size", defaultValue = "5") Integer size,
                                     @RequestParam(value = "page", defaultValue = "0") Integer page){
        return new ResponseEntity<>(carService.getAllCarsByBrand(brandId,size,page), HttpStatus.OK);
    }


    @GetMapping("/getByBody")
    ResponseEntity<?> getAllCarsByBody(@RequestParam(value = "body", defaultValue = "") CarBody body,
                                 @RequestParam(value = "size", defaultValue = "1") Integer size,
                                 @RequestParam(value = "page", defaultValue = "0") Integer page){

        return new ResponseEntity<>(carService.getAllCarsByBody(body, size, page), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @PostMapping("/add")
    ResponseEntity<?> AddCar(@RequestBody CarDTO car){
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @GetMapping("/update/{id}")
    ResponseEntity<?> updateCar(@PathVariable("id") Long carId,@RequestBody CarDTO carDTO){
        carDTO.setId(carId);
        return new ResponseEntity<>(carService.updateCar(carDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @GetMapping("/delete/{id}")
    ResponseEntity<?> deleteCar(@PathVariable("id") Long CarId){
        return new ResponseEntity<>(carService.deleteCar(CarId), HttpStatus.OK);
    }

}
