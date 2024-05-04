package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.City;
import com.CarRental.CarRentalPFA.DTO.CityDTO;

import java.util.List;

public interface CityService {
    List<CityDTO> getAllCities();
    CityDTO addCity(CityDTO city);
    CityDTO updateCity(CityDTO city);
    CityDTO deleteCity(Long cityId);
}
