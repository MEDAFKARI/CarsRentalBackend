package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;

public interface BrandService {
    CarBrand addBrand(CarBrand brand);
    CarBrand updateBrand(CarBrand brand);
    CarBrand deleteBrand(Long brandId);
}
