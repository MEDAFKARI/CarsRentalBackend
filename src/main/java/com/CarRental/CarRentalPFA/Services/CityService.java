package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();
    City addCity(City city);
    City updateCity(City city);
    City deleteCity(City city);
}
