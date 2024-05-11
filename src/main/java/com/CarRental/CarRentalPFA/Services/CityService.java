package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.City;
import com.CarRental.CarRentalPFA.DTO.CityDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CityService {
    Page<CityDTO> getAllCities(String kw, Integer size, Integer page);
    CityDTO addCity(CityDTO city);
    CityDTO updateCity(CityDTO city);
    CityDTO deleteCity(Long cityId);

    CityDTO getCity(Long cityId);
}
