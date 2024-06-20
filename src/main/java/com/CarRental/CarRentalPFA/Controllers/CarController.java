package com.CarRental.CarRentalPFA.Controllers;

import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;
import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
import com.CarRental.CarRentalPFA.DAO.Enum.Fuel;
import com.CarRental.CarRentalPFA.DAO.Enum.Transmission;
import com.CarRental.CarRentalPFA.DTO.BrandDTO;
import com.CarRental.CarRentalPFA.DTO.CarDTO;
import com.CarRental.CarRentalPFA.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/get")
    ResponseEntity<?> getAllCars(@RequestParam(value = "search", defaultValue = "") String kw,
                                 @RequestParam(value = "size", defaultValue = "9") Integer size,
                                 @RequestParam(value = "page", defaultValue = "0") Integer page){

        return new ResponseEntity<>(carService.getAllCarsByModel(kw, size, page), HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    ResponseEntity<?> getCar(@PathVariable("id") Long carID){
        return new ResponseEntity<>(carService.getCar(carID), HttpStatus.OK);
    }

    @GetMapping("/getByStore/{id}")
    ResponseEntity<?> getCarsByStore(@PathVariable("id") Long storeId,
                                     @RequestParam(value = "size", defaultValue = "9") Integer size,
                                     @RequestParam(value = "page", defaultValue = "0") Integer page){
        return new ResponseEntity<>(carService.getAllCarsByStore(storeId,size,page), HttpStatus.OK);
    }

    @GetMapping("/getByBrand")
    ResponseEntity<?> getCarsByBrand(@RequestParam("brand") Long brandId,
                                     @RequestParam(value = "size", defaultValue = "9") Integer size,
                                     @RequestParam(value = "page", defaultValue = "0") Integer page){
        return new ResponseEntity<>(carService.getAllCarsByBrand(brandId,size,page), HttpStatus.OK);
    }


    @GetMapping("/getByBody")
    ResponseEntity<?> getAllCarsByBody(@RequestParam(value = "body", defaultValue = "") CarBody body,
                                 @RequestParam(value = "size", defaultValue = "9") Integer size,
                                 @RequestParam(value = "page", defaultValue = "0") Integer page){

        return new ResponseEntity<>(carService.getAllCarsByBody(body, size, page), HttpStatus.OK);
    }

    @GetMapping("/getByUser")
    ResponseEntity<?> getAllCarsByUser(@RequestParam(value = "id") String Username,
                                       @RequestParam(value = "size", defaultValue = "9") Integer size,
                                       @RequestParam(value = "page", defaultValue = "0") Integer page){

        return new ResponseEntity<>(carService.getAllCarsByUser(Username, size, page), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @PostMapping("/add/{id}")
    ResponseEntity<?> AddCar(@RequestParam("attachment") MultipartFile attachment,
                             @RequestParam("carModel") String carModel,
                             @RequestParam("brand") Long brand,
                             @RequestParam("price") Double price,
                             @RequestParam("body") CarBody body,
                             @RequestParam("availability") boolean availability,
                             @RequestParam("doors") Integer doors,
                             @RequestParam("transmission") Transmission transmission,
                             @RequestParam("fuel") Fuel fuel,
                             @PathVariable("id")String Username) throws IOException {
        CarDTO car = new CarDTO(null,carModel,price,null,body,null,availability,doors,transmission,fuel,null);
        return new ResponseEntity<>(carService.addCar(car, Username ,brand,attachment), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @PutMapping("/update/{id}")
    ResponseEntity<?> updateCar(@PathVariable("id") Long carId,@RequestBody CarDTO carDTO){
        carDTO.setId(carId);
        return new ResponseEntity<>(carService.updateCar(carDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @PutMapping("/updateAvailability")
    ResponseEntity<?> updateCarAvailability(@RequestParam("id") Long carId){
        System.out.print("--------------------- WE HERE");
        return new ResponseEntity<>(carService.updateCarAvailability(carId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteCar(@PathVariable("id") Long CarId){
        return new ResponseEntity<>(carService.deleteCar(CarId), HttpStatus.OK);
    }

}
