package com.CarRental.CarRentalPFA.Controllers;

import com.CarRental.CarRentalPFA.DAO.Entities.City;
import com.CarRental.CarRentalPFA.DTO.CityDTO;
import com.CarRental.CarRentalPFA.Services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/get")
    ResponseEntity<?> getAllCities(){
        return new ResponseEntity<>(cityService.getAllCities(), HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<?> addCity(@RequestBody CityDTO city){
        return new ResponseEntity<>(cityService.addCity(city), HttpStatus.OK);
    }



}
