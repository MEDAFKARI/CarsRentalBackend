package com.CarRental.CarRentalPFA.DTO;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Entities.City;
import com.CarRental.CarRentalPFA.DAO.Entities.User;
import com.CarRental.CarRentalPFA.DAO.Entities.UserReview;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import javax.sound.sampled.ReverbType;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreDTO {
    private Long Id;
    private String storeName;
    private String storeLogo;
    private String storeNumber;
    private CityDTO city;
    private UserDTO owner;
    private ReviewDTO reviews;
    private boolean isConfigured;
}
