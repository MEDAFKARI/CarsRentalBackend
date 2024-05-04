package com.CarRental.CarRentalPFA.Controllers;


import com.CarRental.CarRentalPFA.DTO.StoreDTO;
import com.CarRental.CarRentalPFA.Services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {
    @Autowired
    StoreService storeService;

    @GetMapping("/get")
    ResponseEntity<?> getAllStores(){
        return new ResponseEntity<>(storeService.getAllStores(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @PostMapping("/add")
    ResponseEntity<?> addStore(@RequestBody StoreDTO storeDTO){
        return new ResponseEntity<>(storeService.addStore(storeDTO), HttpStatus.OK);
    }


}
