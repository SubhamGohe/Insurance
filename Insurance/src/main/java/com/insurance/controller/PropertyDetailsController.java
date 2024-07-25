package com.insurance.controller;

import com.insurance.model.PropertyDetailsEntity;
import com.insurance.repository.PropertyDetailsRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
@Validated
public class PropertyDetailsController {

    @Autowired
    private PropertyDetailsRepository propertyDetailsRepository;

    // Create a new property
    @PostMapping
    public ResponseEntity<?> createProperty(@Valid @RequestBody PropertyDetailsEntity propertyDetails, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // If there are validation errors, collect default messages
            StringBuilder errorMessages = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessages.append(error.getDefaultMessage()).append(". ");
            }
            return ResponseEntity.badRequest().body(errorMessages.toString());
        }

        PropertyDetailsEntity savedProperty = propertyDetailsRepository.save(propertyDetails);
        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

    // Get a property by ID
    @GetMapping("/{id}")
    public ResponseEntity<PropertyDetailsEntity> getPropertyById(@PathVariable Long id) {
        Optional<PropertyDetailsEntity> property = propertyDetailsRepository.findById(id);
        return property.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all properties
    @GetMapping
    public ResponseEntity<List<PropertyDetailsEntity>> getAllProperties() {
        List<PropertyDetailsEntity> properties = propertyDetailsRepository.findAll();
        return ResponseEntity.ok(properties);
    }

    // Update a property
    @PutMapping("/{id}")
    public ResponseEntity<PropertyDetailsEntity> updateProperty(@PathVariable Long id, @Valid @RequestBody PropertyDetailsEntity propertyDetails) {
        if (!propertyDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        propertyDetails.setId(id);
        PropertyDetailsEntity updatedProperty = propertyDetailsRepository.save(propertyDetails);
        return ResponseEntity.ok(updatedProperty);
    }

    // Delete a property
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        if (!propertyDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        propertyDetailsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
