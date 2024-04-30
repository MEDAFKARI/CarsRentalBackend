package com.CarRental.CarRentalPFA.Services;


import com.CarRental.CarRentalPFA.DAO.Entities.City;
import com.CarRental.CarRentalPFA.DAO.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;
    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City addCity(City city) {

        return cityRepository.save(city);
    }

    @Override
    public City updateCity(City city) {

        return cityRepository.save(city);
    }

    @Override
    public City deleteCity(Long cityId) {
        City city = cityRepository.findById(cityId).get();
        cityRepository.delete(city);
        return city;
    }
}
