package com.CarRental.CarRentalPFA.Mappers;


import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;
import com.CarRental.CarRentalPFA.DAO.Repositories.BrandRepository;
import com.CarRental.CarRentalPFA.DTO.BrandDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class BrandMapper {

    @Autowired
    BrandRepository brandRepository;

    public BrandDTO convertToDTO(CarBrand carBrand){
        BrandDTO brandDTO = BrandDTO.builder()
                .Id(carBrand.getId())
                .brandName(carBrand.getBrandName())
                .brandLogo(carBrand.getBrandLogo()).build();
        return brandDTO;
    }

    public CarBrand convertToBrand(BrandDTO carBrand){
        CarBrand brand = CarBrand.builder()
                .Id(carBrand.getId())
                .brandName(carBrand.getBrandName())
                .brandLogo(carBrand.getBrandLogo()).build();
        return brand;
    }

}
