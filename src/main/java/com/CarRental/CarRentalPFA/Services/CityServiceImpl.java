package com.CarRental.CarRentalPFA.Services;


import com.CarRental.CarRentalPFA.DAO.Entities.City;
import com.CarRental.CarRentalPFA.DAO.Repositories.CityRepository;
import com.CarRental.CarRentalPFA.DTO.CityDTO;
import com.CarRental.CarRentalPFA.Mappers.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CityMapper cityMapper;


    @Override
    public List<CityDTO> getAllCities() {
        List<CityDTO> cities = cityRepository.findAll()
                .stream()
                .map(city -> cityMapper.convertCityToDTO(city))
                .collect(Collectors.toList());
        System.out.println(cities);
        return cities;
    }


    @Override
    public CityDTO addCity(CityDTO city) {
        System.out.println("Adding city ======> "+ city);
        City c = cityRepository.save(cityMapper.convertCityDTOToCity(city));
        return cityMapper.convertCityToDTO(c);
    }

    @Override
    public CityDTO updateCity(CityDTO city) {

        return null;
    }

    @Override
    public CityDTO deleteCity(Long cityId) {
        City city = cityRepository.findById(cityId).get();
        cityRepository.delete(city);
        return null;
    }
}
