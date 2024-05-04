package com.CarRental.CarRentalPFA.Mappers;

import com.CarRental.CarRentalPFA.DAO.Entities.User;
import com.CarRental.CarRentalPFA.DTO.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    ModelMapper modelMapper;

    public UserDTO convertToUserDTO(User user){
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public User convertToUser(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }



}
