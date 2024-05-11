package com.CarRental.CarRentalPFA.DAO.Entities;

import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
import com.CarRental.CarRentalPFA.DAO.Enum.Transmission;
import com.CarRental.CarRentalPFA.DAO.Enum.Fuel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String carModel;
    private Double price;
    @ManyToOne
    private CarBrand brand;
    @Enumerated(EnumType.STRING)
    private CarBody body;
    private Integer doors;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    private Boolean availability;
    @Enumerated(EnumType.STRING)
    private Fuel fuel;
    private String carImage;
    @ManyToOne
    @JsonIgnore
    private Store store;
    @OneToMany(mappedBy = "car")
    private List<LocationHistorique> historiques;
}
