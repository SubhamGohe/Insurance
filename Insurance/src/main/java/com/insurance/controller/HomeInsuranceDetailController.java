package com.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.insurance.model.HomeInsuranceDetail;
import com.insurance.repository.HomeInsuranceDetailRepository;
import com.insurance.service.HomeInsuranceDetailService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/homeinsurance")
public class HomeInsuranceDetailController {

    @Autowired
    private HomeInsuranceDetailService detailService;
    
    // POST: localhost:8080/api/homeinsurance/details
    @PostMapping("/details")
    public ResponseEntity<String> saveDetails(@Valid @RequestBody HomeInsuranceDetail detail, BindingResult bindingResult) {
        // Check for validation errors
        if (bindingResult.hasErrors()) {
            // If there are validation errors, collect default messages
            StringBuilder errorMessages = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessages.append(error.getDefaultMessage()).append(". ");
            }
            return ResponseEntity.badRequest().body(errorMessages.toString());
        } else {
            detailService.saveDetail(detail);
            return ResponseEntity.ok("Home insurance detail saved successfully.");
        }
    }

    
}
