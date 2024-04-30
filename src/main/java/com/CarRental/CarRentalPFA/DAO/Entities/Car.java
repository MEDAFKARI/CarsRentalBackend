package com.CarRental.CarRentalPFA.DAO.Entities;

import com.CarRental.CarRentalPFA.DAO.Enum.CarBody;
import com.CarRental.CarRentalPFA.DAO.Enum.Transmission;
import com.CarRental.CarRentalPFA.DAO.Enum.Fuel;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
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
    private Integer Doors;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    @Enumerated(EnumType.STRING)
    private Fuel fuel;
    private List<String> carImages;
    @ManyToOne
    private Store store;
    @OneToMany(mappedBy = "car")
    private List<LocationHistorique> historiques;
}
