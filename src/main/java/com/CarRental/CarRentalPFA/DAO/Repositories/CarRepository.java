package com.CarRental.CarRentalPFA.DAO.Repositories;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByStoreId(Long StoreId);
    List<Car> findAllByBrandId(Long Id);
}
