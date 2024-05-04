package com.CarRental.CarRentalPFA.Services;
import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DTO.StoreDTO;

import java.util.List;

public interface StoreService {
    List<StoreDTO> getAllStores();
    List<Store> getAllStoresByCity(Long cityId);

    StoreDTO addStore(StoreDTO store);
    Store updateStore(Store store);
    Store deleteStore(Long storeId);
}
