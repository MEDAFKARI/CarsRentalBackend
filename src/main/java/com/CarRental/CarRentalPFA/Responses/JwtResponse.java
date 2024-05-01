package com.CarRental.CarRentalPFA.Responses;

import com.CarRental.CarRentalPFA.DAO.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String accessToken;
    private Role role;
}
