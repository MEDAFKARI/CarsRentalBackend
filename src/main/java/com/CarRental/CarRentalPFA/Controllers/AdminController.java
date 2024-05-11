package com.CarRental.CarRentalPFA.Controllers;


import com.CarRental.CarRentalPFA.DTO.UserDTO;
import com.CarRental.CarRentalPFA.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/get/userslist")
    ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(adminService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/get/storeOwnersList")
    ResponseEntity<?> getAllStoreOwners(){
        return new ResponseEntity<>(adminService.getAllStoreOwner(),HttpStatus.OK);
    }

    @GetMapping("/get/normalUserList")
    ResponseEntity<?> getAllNormalUsers(){
        return new ResponseEntity<>(adminService.getAllNormalUsers(),HttpStatus.OK);
    }

    @PostMapping("/makeStoreOwner")
    ResponseEntity<?> makeStoreOwner(@RequestParam String Id){
        return new ResponseEntity(adminService.UpdateRoleTo_StoreOwner(Id), HttpStatus.OK);
    }



}
