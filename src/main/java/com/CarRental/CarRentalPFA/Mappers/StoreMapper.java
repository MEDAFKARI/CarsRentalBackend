package com.CarRental.CarRentalPFA.Mappers;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DAO.Entities.User;
import com.CarRental.CarRentalPFA.DAO.Repositories.UserRepository;
import com.CarRental.CarRentalPFA.DTO.StoreDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreMapper {
    @Autowired
    ModelMapper modelMapper;

    public StoreDTO convertStoreToStoreDTO(Store store){
        StoreDTO storeDTO = this.modelMapper.map(store, StoreDTO.class);
        return storeDTO;
    }

    public Store convertToStore(StoreDTO storeDTO){
        Store store = this.modelMapper.map(storeDTO, Store.class);
        return store;
    }


}
