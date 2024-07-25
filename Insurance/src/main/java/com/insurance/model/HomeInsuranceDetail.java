package com.insurance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class HomeInsuranceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long detailId;

    @NotBlank(message = "Country is mandatory")
    @Size(max = 100, message = "Country name must be less than or equal to 100 characters")
    private String country;

    @NotBlank(message = "City name is mandatory")
    @Size(max = 100, message = "City name must be less than or equal to 100 characters")
    private String cityName;

    @NotBlank(message = "Pincode is mandatory")
    @Size(min = 6, max = 10, message = "Pincode must be between 6 and 10 characters")
    private String pincode;

    private String selectedCity;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private SignupEntity signupEntity;
}
