package com.CarRental.CarRentalPFA.Controllers;

import com.CarRental.CarRentalPFA.DAO.Entities.City;
import com.CarRental.CarRentalPFA.DTO.CityDTO;
import com.CarRental.CarRentalPFA.Services.CityService;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    ResponseEntity<?> getAllCities(@RequestParam(value = "search", defaultValue = "") String kw,
                                   @RequestParam(value = "size", defaultValue = "5") Integer size,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page){
        return new ResponseEntity<>(cityService.getAllCities(kw,size,page), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getCity(@PathVariable("id") Long cityId){
        return new ResponseEntity<>(cityService.getCity(cityId), HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<?> addCity(@RequestBody CityDTO city){
        return new ResponseEntity<>(cityService.addCity(city), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateCity(@PathVariable("id") Long Id, @RequestBody CityDTO city){
        city.setId(Id);
        return new ResponseEntity<>(cityService.updateCity(city), HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    ResponseEntity<?> deleteCity(@PathVariable("id") Long Id){
        return new ResponseEntity<>(cityService.deleteCity(Id), HttpStatus.OK);
    }


}
