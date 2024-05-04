package com.CarRental.CarRentalPFA.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandDTO {
    private Long Id;
    private String brandName;
    private String brandLogo;
}
