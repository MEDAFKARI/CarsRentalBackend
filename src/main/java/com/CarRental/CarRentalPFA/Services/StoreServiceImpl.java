package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DAO.Repositories.StoreRepository;
import com.CarRental.CarRentalPFA.DTO.StoreDTO;
import com.CarRental.CarRentalPFA.Mappers.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<StoreDTO> getAllStores(String kw, Integer size, Integer page) {
        Page<StoreDTO> storeDTO = storeRepository.findByStoreNameContaining(kw, PageRequest.of(page,size))
                    .map(store -> storeMapper.convertStoreToStoreDTO(store));
        return storeDTO;
    }

    @Override
    public StoreDTO getStore(Long Id) {
        return storeMapper.convertStoreToStoreDTO(storeRepository.findById(Id).get());
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
    public StoreDTO updateStore(StoreDTO store) {
        Store store1 = storeRepository.save(storeMapper.convertToStore(store));
        StoreDTO storeDTO = storeMapper.convertStoreToStoreDTO(store1);
        return storeDTO;
    }

    @Override
    public StoreDTO deleteStore(Long storeId) {
        Store store = storeRepository.findById(storeId).get();
        storeRepository.delete(store);
        return storeMapper.convertStoreToStoreDTO(store);
    }
}
