package com.insurance.controller;

import com.insurance.model.LoginEntity;
import com.insurance.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/loginAccount")
    public ResponseEntity<String> loginAccount(@Valid @RequestBody LoginEntity loginEntity, BindingResult bindingResult) {
        // Check for validation errors
        if (bindingResult.hasErrors()) {
            // If there are validation errors, collect default messages
            StringBuilder errorMessages = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessages.append(error.getDefaultMessage()).append(". ");
            }
            return ResponseEntity.badRequest().body(errorMessages.toString());
        } else {
            // Proceed with login service
            String account = loginService.loginAccount(loginEntity);

            System.out.println(loginEntity);
            System.out.println(account);

            return ResponseEntity.status(HttpStatus.OK).body(account); // Example response body
        }
    }
}
 
