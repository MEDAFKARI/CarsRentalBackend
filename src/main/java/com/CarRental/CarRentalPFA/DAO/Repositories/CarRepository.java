package com.CarRental.CarRentalPFA.DAO.Repositories;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Page<Car> findAllByStoreId(Long StoreId, Pageable pageable);
    Page<Car> findAllByBrandId(Long Id, Pageable pageable);
    Page<Car> findAllByCarModelContaining(String Kw, Pageable pageable);

    Page<Car> findAllByBody(CarBody body, Pageable pageable);

}
