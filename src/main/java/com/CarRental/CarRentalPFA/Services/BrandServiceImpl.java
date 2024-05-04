package com.CarRental.CarRentalPFA.Services;
import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;
import com.CarRental.CarRentalPFA.DAO.Repositories.BrandRepository;
import com.CarRental.CarRentalPFA.DTO.BrandDTO;
import com.CarRental.CarRentalPFA.Mappers.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    BrandMapper brandMapper;

    @Override
    public List<BrandDTO> getAllBrands() {

        return brandRepository.findAll().stream()
                .map(brand -> brandMapper.convertToDTO(brand))
                .collect(Collectors.toList());
    }

    @Override
    public BrandDTO addBrand(BrandDTO brand) {
        BrandDTO brandDTO = brandMapper
                .convertToDTO(brandRepository.save(brandMapper.convertToBrand(brand)));
        return brandDTO;
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
