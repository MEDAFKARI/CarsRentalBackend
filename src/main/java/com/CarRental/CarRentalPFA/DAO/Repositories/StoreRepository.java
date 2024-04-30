package com.CarRental.CarRentalPFA.DAO.Repositories;

import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByCityId(Long cityId);
}
