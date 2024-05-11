package com.CarRental.CarRentalPFA.Services;
import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;
import com.CarRental.CarRentalPFA.DAO.Repositories.BrandRepository;
import com.CarRental.CarRentalPFA.DTO.BrandDTO;
import com.CarRental.CarRentalPFA.Mappers.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<BrandDTO> getAllBrands(String kw, Integer size, Integer page) {

        return brandRepository.findByBrandNameContaining(kw, PageRequest.of(page, size))
                .map(brand -> brandMapper.convertToDTO(brand));
    }

    @Override
    public BrandDTO getBrand(Long brandId) {
        return brandMapper.convertToDTO(brandRepository.findById(brandId).get());
    }

    @Override
    public BrandDTO addBrand(BrandDTO brand) {
        BrandDTO brandDTO = brandMapper
                .convertToDTO(brandRepository.save(brandMapper.convertToBrand(brand)));
        return brandDTO;
    }

    @Override
    public BrandDTO updateBrand(BrandDTO brand) {
        BrandDTO brandDTO = brandMapper
                .convertToDTO(brandRepository.save(brandMapper.convertToBrand(brand)));
        return brandDTO;    }

    @Override
    public BrandDTO deleteBrand(Long brandId) {
        CarBrand brand = brandRepository.findById(brandId).get();
        brandRepository.delete(brand);
        return brandMapper.convertToDTO(brand);
    }
}
