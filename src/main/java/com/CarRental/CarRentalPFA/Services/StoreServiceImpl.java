package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DAO.Repositories.CityRepository;
import com.CarRental.CarRentalPFA.DAO.Repositories.StoreRepository;
import com.CarRental.CarRentalPFA.DAO.Repositories.UserRepository;
import com.CarRental.CarRentalPFA.DTO.StoreDTO;
import com.CarRental.CarRentalPFA.Mappers.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StoreMapper storeMapper;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    UserRepository userRepository;


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
    public StoreDTO getStoreByUserId(String userId) {
        return storeMapper.convertStoreToStoreDTO(userRepository.findById(userId).get().getStore());
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

    public String uploadfile(MultipartFile file) throws IOException {
        String filePATH = Host.LOCAL + file.getOriginalFilename(); // saved path locally
        String fileUrl = Host.HOSTNAME + file.getOriginalFilename();
        Files.write(Paths.get(filePATH),file.getBytes());
        return fileUrl;
    }

    @Override
    public StoreDTO updateStore(Long Id, String storeNumber, MultipartFile storeLogo, String storeName, Long cityId) throws IOException {
        Store store1 = storeRepository.findById(Id).get();
        store1.setStoreNumber(storeNumber);
        store1.setStoreLogo(uploadfile(storeLogo));
        store1.setStoreName(storeName);
        store1.setCity(cityRepository.findById(cityId).get());
        store1.setConfigured(true);
        StoreDTO storeDTO = storeMapper.convertStoreToStoreDTO(storeRepository.save(store1));
        System.out.println("-----------------------------------------------------------");
        System.out.println(storeDTO);
        System.out.println("-----------------------------------------------------------");
        return storeDTO;
    }


    @Override
    public StoreDTO updateStoreLogo(Long id, MultipartFile storeLogo) throws IOException {
        Store store1 = storeRepository.findById(id).get();
        store1.setStoreLogo(uploadfile(storeLogo));
        StoreDTO storeDTO = storeMapper.convertStoreToStoreDTO(storeRepository.save(store1));
        return storeDTO;
    }

    @Override
    public StoreDTO updateStoreInfos(Long id, String storeNumber, String storeName, Long cityId) {
        Store store1 = storeRepository.findById(id).get();
        store1.setStoreNumber(storeNumber);
        store1.setStoreName(storeName);
        store1.setCity(cityRepository.findById(cityId).get());
        StoreDTO storeDTO = storeMapper.convertStoreToStoreDTO(storeRepository.save(store1));
        System.out.println("-----------------------------------------------------------");
        System.out.println(storeDTO);
        System.out.println("-----------------------------------------------------------");
        return storeDTO;
    }

    @Override
    public StoreDTO deleteStore(Long storeId) {
        Store store = storeRepository.findById(storeId).get();
        storeRepository.delete(store);
        return storeMapper.convertStoreToStoreDTO(store);
    }


}
