package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DAO.Repositories.StoreRepository;
import com.CarRental.CarRentalPFA.DTO.StoreDTO;
import com.CarRental.CarRentalPFA.Mappers.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StoreMapper storeMapper;


    @Override
    public List<StoreDTO> getAllStores() {
        List<StoreDTO> storeDTO = storeRepository.findAll().stream().map(store -> storeMapper.convertStoreToStoreDTO(store)).collect(Collectors.toList());
        return storeDTO;
    }

    @Override
    public List<Store> getAllStoresByCity(Long cityId) {

        return storeRepository.findAllByCityId(cityId);
    }

    @Override
    public StoreDTO addStore(StoreDTO store) {
        System.out.println(store);
        StoreDTO storeDTO = storeMapper
                .convertStoreToStoreDTO(
                        storeRepository
                                .save(storeMapper.convertToStore(store)));
        return storeDTO;
    }

    @Override
    public Store updateStore(Store store) {

        return storeRepository.save(store);
    }

    @Override
    public Store deleteStore(Long storeId) {
        Store store = storeRepository.findById(storeId).get();
        storeRepository.delete(store);
        return store;
    }
}
