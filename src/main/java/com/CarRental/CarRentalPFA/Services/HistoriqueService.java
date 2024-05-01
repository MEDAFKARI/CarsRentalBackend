package com.CarRental.CarRentalPFA.Services;


import com.CarRental.CarRentalPFA.DAO.Entities.LocationHistorique;

import java.util.List;

public interface HistoriqueService {
    List<LocationHistorique> getUserHistorique(String username);
    LocationHistorique addHistorique(LocationHistorique historique);
    LocationHistorique updateHistorique(LocationHistorique historique);
    LocationHistorique deleteHistorique(Long historiqueId);
}
