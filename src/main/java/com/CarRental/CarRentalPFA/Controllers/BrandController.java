package com.CarRental.CarRentalPFA.Controllers;

import com.CarRental.CarRentalPFA.DTO.BrandDTO;
import com.CarRental.CarRentalPFA.Services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("/get")
    ResponseEntity<?> getAllBrands(){
        return new ResponseEntity<>(brandService.getAllBrands(), HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<?> addBrand(@RequestBody BrandDTO brandDTO){
        return new ResponseEntity<>(brandService.addBrand(brandDTO), HttpStatus.OK);
    }
}
