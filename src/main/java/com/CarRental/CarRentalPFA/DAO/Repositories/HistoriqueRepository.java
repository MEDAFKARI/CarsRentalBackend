package com.CarRental.CarRentalPFA.DAO.Repositories;

import com.CarRental.CarRentalPFA.DAO.Entities.LocationHistorique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriqueRepository extends JpaRepository<LocationHistorique, Long> {
    List<LocationHistorique> findAllByUserUsername(String userId);
}
