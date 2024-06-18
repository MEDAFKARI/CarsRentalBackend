package com.CarRental.CarRentalPFA.Controllers;


import com.CarRental.CarRentalPFA.DTO.StoreDTO;
import com.CarRental.CarRentalPFA.Services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {
    @Autowired
    StoreService storeService;

    @GetMapping("/get")
    ResponseEntity<?> getAllStores(@RequestParam(value = "search", defaultValue = "") String kw,
    @RequestParam(value = "size", defaultValue = "5") Integer size,
    @RequestParam(value = "page", defaultValue = "0") Integer page){
        return new ResponseEntity<>(storeService.getAllStores(kw, size, page), HttpStatus.OK);
    }


    @GetMapping("/getByCity/{id}")
    ResponseEntity<?> getStoreByCity(@PathVariable("id") Long cityId){
        return new ResponseEntity<>(storeService.getAllStoresByCity(cityId), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getStore(@PathVariable("id") Long storeId){
        return new ResponseEntity<>(storeService.getStore(storeId), HttpStatus.OK);
    }

    @GetMapping("/getByUser/{id}")
    ResponseEntity<?> getStoreByUser(@PathVariable("id") String userId){
        return new ResponseEntity<>(storeService.getStoreByUserId(userId), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @PutMapping("/update/{id}")
    ResponseEntity<?> updateStore(@PathVariable("id") Long Id ,
                                  @RequestParam("storeName") String storeName,
                                  @RequestParam("storeNumber") String storeNumber,
                                  @RequestParam("attachment")MultipartFile storeLogo,
                                  @RequestParam("city") Long cityId) throws IOException {
        return new ResponseEntity<>(storeService.updateStore(Id,storeNumber,storeLogo,storeName,cityId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteStore(@PathVariable("id") Long Id ){
        return new ResponseEntity<>(storeService.deleteStore(Id), HttpStatus.OK);
    }
}
