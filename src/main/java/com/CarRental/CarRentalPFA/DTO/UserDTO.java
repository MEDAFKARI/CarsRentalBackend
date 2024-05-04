package com.CarRental.CarRentalPFA.DTO;

import com.CarRental.CarRentalPFA.DAO.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String email;
    private Role role;
}
