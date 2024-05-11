package com.CarRental.CarRentalPFA.Controllers;

import com.CarRental.CarRentalPFA.DTO.BrandDTO;
import com.CarRental.CarRentalPFA.Services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("/get")
    ResponseEntity<?> getAllBrands(@RequestParam(value = "search", defaultValue = "") String kw,
                                   @RequestParam(value = "size", defaultValue = "5") Integer size,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page){
        return new ResponseEntity<>(brandService.getAllBrands(kw, size,page), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getBrand(@PathVariable("id") Long brandId){
        return new ResponseEntity<>(brandService.getBrand(brandId), HttpStatus.OK);
    }


//    @PreAuthorize("hasAuthority('ADMIN')")

    @PostMapping("/add")
    ResponseEntity<?> addBrand(@RequestBody BrandDTO brandDTO){
        return new ResponseEntity<>(brandService.addBrand(brandDTO), HttpStatus.OK);
    }
//    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update/{id}")
    ResponseEntity<?> updateBrand(@PathVariable("id") Long brandId,  @RequestBody BrandDTO brandDTO){
        brandDTO.setId(brandId);
        return new ResponseEntity<>(brandService.updateBrand(brandDTO), HttpStatus.OK);
    }
//    @PreAuthorize("hasAuthority('ADMIN')")

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteBrand(@PathVariable("id") Long brandId){
        return new ResponseEntity<>(brandService.deleteBrand(brandId), HttpStatus.OK);
    }
}
