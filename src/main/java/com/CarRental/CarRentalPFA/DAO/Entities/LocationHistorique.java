package com.CarRental.CarRentalPFA.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationHistorique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    private Car car;
    @ManyToOne
    @JsonIgnore

    private Store store;
    @ManyToOne
    private User user;
    private Date date;
}
