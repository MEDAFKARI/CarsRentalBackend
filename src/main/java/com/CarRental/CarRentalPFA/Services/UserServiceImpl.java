package com.CarRental.CarRentalPFA.Services;


import com.CarRental.CarRentalPFA.DAO.Entities.User;
import com.CarRental.CarRentalPFA.DAO.Repositories.UserRepository;
import com.CarRental.CarRentalPFA.DTO.UserDTO;
import com.CarRental.CarRentalPFA.Mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    @Override
    public UserDTO getUserInformations(String username) {
        return userMapper.convertToUserDTO(userRepository.getById(username));
    }


    public String uploadfile(MultipartFile file) throws IOException {
        String filePATH = Host.LOCAL + file.getOriginalFilename(); // saved path locally
        String fileUrl = Host.HOSTNAME + file.getOriginalFilename();
        Files.write(Paths.get(filePATH),file.getBytes());
        return fileUrl;
    }

    @Override
    public UserDTO updateProfilePicture(String username, MultipartFile profilePicture) throws IOException {
        User user = userRepository.getById(username);
        user.setProfilePicture(uploadfile(profilePicture));
        return userMapper.convertToUserDTO(userRepository.save(user));
    }

    @Override
    public UserDTO updateProfileInformations(String username,String email) {
        User user = userRepository.getById(username);
        user.setEmail(email);
        return userMapper.convertToUserDTO(userRepository.save(user));
    }
}
