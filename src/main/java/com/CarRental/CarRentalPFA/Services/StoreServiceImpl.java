package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DAO.Repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;


    @Override
    public List<Store> getAllStores() {

        return storeRepository.findAll();
    }

    @Override
    public List<Store> getAllStoresByCity(Long cityId) {

        return storeRepository.findAllByCityId(cityId);
    }

    @Override
    public Store addStore(Store store) {

        return storeRepository.save(store);
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
