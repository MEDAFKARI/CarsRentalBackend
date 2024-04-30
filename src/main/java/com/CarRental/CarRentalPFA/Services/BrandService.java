package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;

import java.util.List;

public interface BrandService {
    List<CarBrand> getAllBrands();
    CarBrand addBrand(CarBrand brand);
    CarBrand updateBrand(CarBrand brand);
    CarBrand deleteBrand(Long brandId);
}
