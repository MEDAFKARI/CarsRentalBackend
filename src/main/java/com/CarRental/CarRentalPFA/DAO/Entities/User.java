package com.CarRental.CarRentalPFA.DAO.Entities;

import com.CarRental.CarRentalPFA.DAO.Enum.Role;
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
@Table(name = "users")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(mappedBy = "owner")
    @JsonIgnore
    private Store store;
    @OneToMany(mappedBy = "user")
    private List<UserReview> reviews;
    @OneToMany(mappedBy = "user")
    private List<LocationHistorique> Historiques;

}
