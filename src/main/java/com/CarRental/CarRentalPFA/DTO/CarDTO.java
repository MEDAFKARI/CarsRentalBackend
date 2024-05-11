package com.CarRental.CarRentalPFA.DTO;

import com.CarRental.CarRentalPFA.DAO.Entities.CarBrand;
import com.CarRental.CarRentalPFA.DAO.Entities.LocationHistorique;
import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
import com.CarRental.CarRentalPFA.DAO.Enum.Fuel;
import com.CarRental.CarRentalPFA.DAO.Enum.Transmission;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDTO {
    private Long Id;
    private String carModel;
    private Double price;
    private BrandDTO brand;
    private CarBody body;
    private String carImage;
    private Boolean availability;
    private Integer doors;
    private Transmission transmission;
    private Fuel fuel;
    private StoreDTO store;
}
