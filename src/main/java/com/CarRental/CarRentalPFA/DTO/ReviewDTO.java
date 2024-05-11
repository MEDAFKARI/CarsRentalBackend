package com.CarRental.CarRentalPFA.DTO;


import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DAO.Entities.User;
import jakarta.persistence.ManyToOne;

public class ReviewDTO {
    private Long Id;
    private UserDTO user;
    private StoreDTO store;
    private Integer points;
}
