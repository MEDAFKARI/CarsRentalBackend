package com.CarRental.CarRentalPFA.DTO;

import com.CarRental.CarRentalPFA.DAO.Entities.Car;
import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DAO.Entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoriqueDTO {
    private String carModel;
    private String storeName;
    private String username;
}
