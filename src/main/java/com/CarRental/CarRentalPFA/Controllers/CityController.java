package com.CarRental.CarRentalPFA.Controllers;

import com.CarRental.CarRentalPFA.DAO.Entities.City;
import com.CarRental.CarRentalPFA.Services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/add/u")
    ResponseEntity<?> getAllStores(@RequestBody City city){
        return new ResponseEntity<>(cityService.addCity(city), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add/a")
    ResponseEntity<?> createCity(@RequestBody City city){
        return new ResponseEntity<>(cityService.addCity(city), HttpStatus.OK);
    }

}
