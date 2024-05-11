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

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @PostMapping("/add")
    ResponseEntity<?> addStore(@RequestBody StoreDTO storeDTO){
        return new ResponseEntity<>(storeService.addStore(storeDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @PostMapping("/update/{id}")
    ResponseEntity<?> updateStore(@PathVariable("id") Long Id ,@RequestBody StoreDTO storeDTO){
        storeDTO.setId(Id);
        return new ResponseEntity<>(storeService.updateStore(storeDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STORE_OWNER')")
    @PostMapping("/delete/{id}")
    ResponseEntity<?> deleteStore(@PathVariable("id") Long Id ){
        return new ResponseEntity<>(storeService.deleteStore(Id), HttpStatus.OK);
    }
}
