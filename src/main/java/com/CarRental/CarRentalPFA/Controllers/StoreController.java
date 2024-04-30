package com.CarRental.CarRentalPFA.Controllers;


import com.CarRental.CarRentalPFA.Services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {
    @Autowired
    StoreService storeService;

    @GetMapping("/get")
    ResponseEntity<?> getAllStores(){
        return new ResponseEntity<>(storeService.getAllStores(), HttpStatus.OK);
    }


}
