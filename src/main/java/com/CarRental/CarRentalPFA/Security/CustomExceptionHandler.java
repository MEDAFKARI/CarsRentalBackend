package com.CarRental.CarRentalPFA.Security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleSecurityException(Exception ex) {
        ResponseEntity<String> response = null;
        System.out.println("### " + ex.getClass().getName() + " - " + ex.getMessage());

        if (ex instanceof BadCredentialsException) {
            System.out.println("*************\n");
            System.out.println("invalid creds");
            response = new ResponseEntity<>(
                    "Invalid Credentials",
                    HttpStatus.UNAUTHORIZED
            );
        }

        if (ex instanceof AccessDeniedException) {
            System.out.println("*************\n");
            System.out.println("access denied");
            response = new ResponseEntity<> (
                    "Unauthorized action !",
                    HttpStatus.FORBIDDEN
            );
        }

        if (ex instanceof SignatureException) {
            System.out.println("*************\n");
            System.out.println("access denied");
            response = new ResponseEntity<> (
                    "Jwt signature is not valid",
                    HttpStatus.FORBIDDEN
            );
        }

        if (ex instanceof ExpiredJwtException) {
            System.out.println("*************\n");
            System.out.println("access denied");
            response = new ResponseEntity<> (
                    "Token already expired",
                    HttpStatus.FORBIDDEN
            );
        }

        return response;
    }

}