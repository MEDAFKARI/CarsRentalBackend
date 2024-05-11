package com.CarRental.CarRentalPFA.Mappers;

import com.CarRental.CarRentalPFA.DAO.Entities.LocationHistorique;
import com.CarRental.CarRentalPFA.DTO.HistoriqueDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoriqueMapper {

    @Autowired
    ModelMapper modelMapper;

    public HistoriqueDTO toHistoriqueDto(LocationHistorique locationHistorique){
        HistoriqueDTO historiqueDTO = modelMapper.map(locationHistorique, HistoriqueDTO.class);
        return historiqueDTO;
    }

    public LocationHistorique toHistorique(HistoriqueDTO historiqueDTO){
        LocationHistorique locationHistorique= modelMapper.map(historiqueDTO, LocationHistorique.class);
        return locationHistorique;
    }

}
