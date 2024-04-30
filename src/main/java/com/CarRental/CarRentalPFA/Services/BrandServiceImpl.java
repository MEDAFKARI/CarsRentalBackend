package com.CarRental.CarRentalPFA.Services;
import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;
import com.CarRental.CarRentalPFA.DAO.Repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<CarBrand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public CarBrand addBrand(CarBrand brand) {

        return brandRepository.save(brand);
    }

    @Override
    public CarBrand updateBrand(CarBrand brand) {

        return brandRepository.save(brand);
    }

    @Override
    public CarBrand deleteBrand(Long brandId) {
        CarBrand brand = brandRepository.findById(brandId).get();
        brandRepository.delete(brand);
        return brand;
    }
}
