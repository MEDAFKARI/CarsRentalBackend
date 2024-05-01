package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.LocationHistorique;
import com.CarRental.CarRentalPFA.DAO.Repositories.HistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueServiceImpl implements HistoriqueService{
    @Autowired
    HistoriqueRepository historiqueRepository;
    @Override
    public List<LocationHistorique> getUserHistorique(String username) {

        return historiqueRepository.findAllByUserUsername(username);
    }

    @Override
    public LocationHistorique addHistorique(LocationHistorique historique) {

        return historiqueRepository.save(historique);
    }

    @Override
    public LocationHistorique updateHistorique(LocationHistorique historique) {

        return historiqueRepository.save(historique);
    }

    @Override
    public LocationHistorique deleteHistorique(Long historiqueId) {
        LocationHistorique historique1= historiqueRepository.findById(historiqueId).get();
        historiqueRepository.delete(historique1);
        return historique1;
    }
}
