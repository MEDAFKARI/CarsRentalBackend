package com.CarRental.CarRentalPFA.DAO.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String storeName;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "store")
    private List<Car> cars;
    @OneToMany(mappedBy = "store")
    private List<UserReview> review;
    @OneToOne
    private User owner;
    @OneToMany(mappedBy = "store")
    private List<LocationHistorique> historiques;

}
