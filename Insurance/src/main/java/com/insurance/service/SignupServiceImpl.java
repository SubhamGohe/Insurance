package com.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insurance.model.SignupEntity;
import com.insurance.repository.SignupRepository;

@Service
public class SignupServiceImpl implements SignupService {

    @Autowired
    private SignupRepository signupRepository;

    @Override
    public String createAccount(SignupEntity signupEntity) {
        // Check if phone number already exists
        SignupEntity existingPhoneEntity = signupRepository.findByPhoneNumber(signupEntity.getPhoneNumber());
        if (existingPhoneEntity != null) {
            return "Phone Number is already registered";
        }

        // Check if email ID already exists
        SignupEntity existingEmailEntity = signupRepository.findByEmailId(signupEntity.getEmailId());
        if (existingEmailEntity != null) {
            return "Email ID is already registered";
        }

        // If neither phone number nor email ID is already registered, save the entity
        signupRepository.save(signupEntity);
        return "Account created successfully";
    }
}


