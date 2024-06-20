package com.CarRental.CarRentalPFA.Controllers;


import com.CarRental.CarRentalPFA.DTO.UserDTO;
import com.CarRental.CarRentalPFA.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/get/userslist")
    ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(adminService.getAllUsers(),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/get/storeOwnersList")
    ResponseEntity<?> getAllStoreOwners(){
        return new ResponseEntity<>(adminService.getAllStoreOwner(),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/get/normalUserList")
    ResponseEntity<?> getAllNormalUsers(){
        return new ResponseEntity<>(adminService.getAllNormalUsers(),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/makeStoreOwner/{id}")
    ResponseEntity<?> makeStoreOwner(@PathVariable("id") String Id){
        System.out.println(Id);
        return new ResponseEntity(adminService.UpdateRoleTo_StoreOwner(Id), HttpStatus.OK);
    }



}
