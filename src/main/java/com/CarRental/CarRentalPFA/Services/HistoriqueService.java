package com.CarRental.CarRentalPFA.Services;


import com.CarRental.CarRentalPFA.DAO.Entities.LocationHistorique;
import com.CarRental.CarRentalPFA.DTO.HistoriqueDTO;

import java.util.List;

public interface HistoriqueService {
    List<HistoriqueDTO> getUserHistorique(String username);
    HistoriqueDTO addHistorique(HistoriqueDTO historique);
    HistoriqueDTO updateHistorique(HistoriqueDTO historique);
    HistoriqueDTO deleteHistorique(Long historiqueId);
}
