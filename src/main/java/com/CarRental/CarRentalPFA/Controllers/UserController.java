package com.CarRental.CarRentalPFA.Controllers;


import com.CarRental.CarRentalPFA.DAO.Entities.User;
import com.CarRental.CarRentalPFA.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.SSLEngineResult;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getUserInformations/{id}")
    ResponseEntity<?> getUserInformations(@PathVariable("id") String Username){
        return new ResponseEntity<>( userService.getUserInformations(Username),HttpStatus.OK);
    }

    @PutMapping("/updateProfilePic/{id}")
    ResponseEntity<?> updateUserPicture(@PathVariable("id") String Username,
                                        @RequestParam("attachment")MultipartFile profilePicture) throws IOException {
        return new ResponseEntity<>( userService.updateProfilePicture(Username,profilePicture),HttpStatus.OK);
    }

    @PutMapping("/updateProfileInformations/{id}")
    ResponseEntity<?> updateUserInformations(@PathVariable("id") String Username,
                                             @RequestParam("Email") String email){
        return new ResponseEntity<>(userService.updateProfileInformations(Username,email),HttpStatus.OK);
    }
}
