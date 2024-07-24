package com.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.SignupEntity;
import com.insurance.service.SignupService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class SignupController {

    @Autowired
    private SignupService signupService;

    // Endpoint to create a new account
    @PostMapping("/createAccount")
    public ResponseEntity<String> createAccount(@Valid @RequestBody SignupEntity signupEntity, BindingResult bindingResult) {
        try {
            // Check for validation errors
            if (bindingResult.hasErrors()) {
                // If there are validation errors, collect default messages
                StringBuilder errorMessages = new StringBuilder();
                for (FieldError error : bindingResult.getFieldErrors()) {
                    errorMessages.append(error.getDefaultMessage()).append(". ");
                }
                return ResponseEntity.badRequest().body(errorMessages.toString());
            }

            // If no validation errors, proceed with account creation
            String createAccountResult = signupService.createAccount(signupEntity);
           
            return ResponseEntity.status(HttpStatus.CREATED).body(createAccountResult);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during account creation");
        }
    }
}
