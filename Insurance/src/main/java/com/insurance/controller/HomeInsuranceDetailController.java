package com.insurance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.insurance.model.HomeInsuranceDetail;
import com.insurance.repository.HomeInsuranceDetailRepository;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/homeinsurance")
public class HomeInsuranceDetailController {

    @Autowired
    private HomeInsuranceDetailRepository repository;
    
    //localhost:8080/api/homeinsurance/details
    @PostMapping("/details")
    public HomeInsuranceDetail saveDetails(@Valid @RequestBody HomeInsuranceDetail detail) {
        return repository.save(detail);
    }

    @GetMapping("/details")
    public List<HomeInsuranceDetail> getAllDetails() {
        return repository.findAll();
    }
}
