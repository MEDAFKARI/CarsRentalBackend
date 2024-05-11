package com.CarRental.CarRentalPFA.Services;


import com.CarRental.CarRentalPFA.DAO.Entities.City;
import com.CarRental.CarRentalPFA.DAO.Repositories.CityRepository;
import com.CarRental.CarRentalPFA.DTO.CityDTO;
import com.CarRental.CarRentalPFA.Mappers.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<CityDTO> getAllCities(String kw, Integer size, Integer page) {
        Page<CityDTO> cities = cityRepository
                .findByCityNameContaining(kw, PageRequest.of(page,size))
                .map(city -> cityMapper.convertCityToDTO(city));
        System.out.println(cities);
        return cities;
    }

    @Override
    public CityDTO getCity(Long cityId) {
        City c = cityRepository.findById(cityId).get();
        return cityMapper.convertCityToDTO(c);
    }


    @Override
    public CityDTO addCity(CityDTO city) {
        System.out.println("Adding city ======> "+ city);
        City c = cityRepository.save(cityMapper.convertCityDTOToCity(city));
        return cityMapper.convertCityToDTO(c);
    }

    @Override
    public CityDTO updateCity(CityDTO city) {
        City c = cityRepository.save(cityMapper.convertCityDTOToCity(city));
        return cityMapper.convertCityToDTO(c);
    }

    @Override
    public CityDTO deleteCity(Long cityId) {
        City city = cityRepository.findById(cityId).get();
        cityRepository.delete(city);
        return cityMapper.convertCityToDTO(city);
    }


}
