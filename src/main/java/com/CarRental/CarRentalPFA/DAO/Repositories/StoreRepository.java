package com.CarRental.CarRentalPFA.DAO.Repositories;

import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;
import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByCityId(Long cityId);

    Page<Store> findByStoreNameContaining(String kw, PageRequest of);
}
