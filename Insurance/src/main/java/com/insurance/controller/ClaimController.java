package com.insurance.controller;

import com.insurance.model.Claim;
import com.insurance.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService service;

    @PostMapping
    public ResponseEntity<String> createClaim(@Valid @RequestBody Claim claim, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessages.append(error.getDefaultMessage()).append(". ");
            }
            return ResponseEntity.badRequest().body(errorMessages.toString());
        } else {
            service.saveClaim(claim);
            return ResponseEntity.ok("Claim created successfully.");
        }
    }

    @GetMapping
    public List<Claim> getAllClaims() {
        return service.getAllClaims();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        Optional<Claim> claim = service.getClaimById(id);
        return claim.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClaim(@PathVariable Long id) {
        Optional<Claim> claim = service.getClaimById(id);
        if (claim.isPresent()) {
            service.deleteClaim(id);
            return ResponseEntity.ok("Claim deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
