package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.User;
import com.CarRental.CarRentalPFA.DAO.Enum.Role;
import com.CarRental.CarRentalPFA.DAO.Repositories.UserRepository;
import com.CarRental.CarRentalPFA.DTO.UserDTO;
import com.CarRental.CarRentalPFA.Mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;


    public UserDTO UpdateRoleTo_StoreOwner(String Id){
        User user = userRepository.findById(Id).orElseThrow();
        user.setRole(Role.STORE_OWNER);
        userRepository.save(user);
        UserDTO userDTO= userMapper.convertToUserDTO(user);
        return userDTO;
    }




}
