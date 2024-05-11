package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.LocationHistorique;
import com.CarRental.CarRentalPFA.DAO.Repositories.HistoriqueRepository;
import com.CarRental.CarRentalPFA.DTO.HistoriqueDTO;
import com.CarRental.CarRentalPFA.Mappers.HistoriqueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoriqueServiceImpl implements HistoriqueService{
    @Autowired
    HistoriqueRepository historiqueRepository;
    @Autowired
    HistoriqueMapper historiqueMapper;

    @Override
    public List<HistoriqueDTO> getUserHistorique(String username) {
        List<LocationHistorique> locationHistorique =historiqueRepository.findAllByUserUsername(username);
    List<HistoriqueDTO> historiqueDTOS = locationHistorique.stream().map(Histo -> historiqueMapper.toHistoriqueDto(Histo)).collect(Collectors.toList());
        return historiqueDTOS;
    }

    @Override
    public HistoriqueDTO addHistorique(HistoriqueDTO historique) {
        LocationHistorique hs = historiqueRepository.save(historiqueMapper.toHistorique(historique));
        HistoriqueDTO historiqueDTO = historiqueMapper.toHistoriqueDto(hs);
        return historiqueDTO;
    }

    @Override
    public HistoriqueDTO updateHistorique(HistoriqueDTO historique) {
        LocationHistorique locationHistorique = historiqueRepository.save( historiqueMapper.toHistorique(historique));
        HistoriqueDTO historiqueDTO = historiqueMapper.toHistoriqueDto(locationHistorique);
        return historiqueDTO;
    }

    @Override
    public HistoriqueDTO deleteHistorique(Long historiqueId) {
        LocationHistorique historique1= historiqueRepository.findById(historiqueId).get();
        historiqueRepository.delete(historique1);
        HistoriqueDTO histo= historiqueMapper.toHistoriqueDto(historique1);
        return histo;
    }
}
