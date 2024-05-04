package com.CarRental.CarRentalPFA.Mappers;

import com.CarRental.CarRentalPFA.DAO.Entities.City;
import com.CarRental.CarRentalPFA.DTO.CityDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CityDTO convertCityToDTO(City city){
        CityDTO cityDTO = this.modelMapper.map(city, CityDTO.class);
        return cityDTO;
    }

    public City convertCityDTOToCity(CityDTO cityDTO){
        City city = this.modelMapper.map(cityDTO, City.class);
        return city;
    }



}
