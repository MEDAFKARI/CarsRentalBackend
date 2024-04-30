package com.CarRental.CarRentalPFA.Services;
import com.CarRental.CarRentalPFA.DAO.Entities.Store;

import java.util.List;

public interface StoreService {
    List<Store> getAllStores();
    List<Store> getAllStoresByCity();
    Store addStore(Store store);
    Store updateStore(Store store);
    Store deleteStore(Long storeId);
}
