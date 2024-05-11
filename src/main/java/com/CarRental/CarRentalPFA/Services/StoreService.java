package com.CarRental.CarRentalPFA.Services;
import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DTO.StoreDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StoreService {
    Page<StoreDTO> getAllStores(String kw, Integer size, Integer page);
    StoreDTO getStore(Long Id);


    List<Store> getAllStoresByCity(Long cityId);

    StoreDTO addStore(StoreDTO store);
    StoreDTO updateStore(StoreDTO store);
    StoreDTO deleteStore(Long storeId);
}
