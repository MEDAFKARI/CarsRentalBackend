package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;
import com.CarRental.CarRentalPFA.DTO.BrandDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BrandService {
    Page<BrandDTO> getAllBrands(String kw, Integer size, Integer page);

    BrandDTO getBrand(Long brandId);

    BrandDTO addBrand(BrandDTO brand);
    BrandDTO updateBrand(BrandDTO brand);
    BrandDTO deleteBrand(Long brandId);

}
