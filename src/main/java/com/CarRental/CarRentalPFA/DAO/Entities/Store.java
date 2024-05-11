package com.CarRental.CarRentalPFA.DAO.Entities;

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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String storeName;
    private String StoreNumber;
    private String storeLogo;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER)
    private List<Car> cars;
    @OneToMany(mappedBy = "store")
    private List<UserReview> review;
    @OneToOne
    private User owner;


}
