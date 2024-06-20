package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DTO.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    UserDTO getUserInformations(String username);

    UserDTO updateProfilePicture(String username, MultipartFile profilePicture) throws IOException;

    UserDTO updateProfileInformations(String username ,String email);
}
