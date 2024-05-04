package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;
import com.CarRental.CarRentalPFA.DTO.BrandDTO;

import java.util.List;

public interface BrandService {
    List<BrandDTO> getAllBrands();
    BrandDTO addBrand(BrandDTO brand);
    CarBrand updateBrand(CarBrand brand);
    CarBrand deleteBrand(Long brandId);
}
