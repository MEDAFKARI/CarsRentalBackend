package com.CarRental.CarRentalPFA.Controllers;

import com.CarRental.CarRentalPFA.DAO.Entities.City;
import com.CarRental.CarRentalPFA.Requests.SigninRequest;
import com.CarRental.CarRentalPFA.Requests.SignupRequest;
import com.CarRental.CarRentalPFA.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/signin")
    ResponseEntity<?> signin(@RequestBody SigninRequest req){
        return new ResponseEntity<>(authService.login(req), HttpStatus.OK);
    }

    @PostMapping("/signup")
    ResponseEntity<?> signup(@RequestBody SignupRequest req){
        return new ResponseEntity<>(authService.signup(req), HttpStatus.OK);
    }
}
