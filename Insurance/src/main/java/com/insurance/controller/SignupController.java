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
    SignupService signupService;
      //localhost:8080/api/createAccount
    // Endpoint to create a new account
    @PostMapping("/createAccount")
    public ResponseEntity<String> createAccount(@Valid @RequestBody SignupEntity signupEntity, BindingResult bindingResult) {
        // Check for validation errors
        if (bindingResult.hasErrors()) {
            // If there are validation errors, collect default messages
            StringBuilder errorMessages = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessages.append(error.getDefaultMessage()).append(". ");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages.toString());
        }

        // If no validation errors, proceed with account creation
        String createAccountResult = signupService.createAccount(signupEntity);
        System.out.println(createAccountResult);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccountResult);
    }
}
