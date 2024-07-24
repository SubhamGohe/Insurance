package com.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.model.LoginEntity;
import com.insurance.model.SignupEntity;
import com.insurance.repository.SignupRepository;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SignupRepository repository;

    @Override
    public String loginAccount(LoginEntity loginEntity) {
        // Check if a user exists with the provided phone number
        SignupEntity existingPhoneEntity = repository.findByPhoneNumber(loginEntity.getPhoneNumber());
        if (existingPhoneEntity == null) {
            return "Invalid Phone Number";
        }

        // Check if the provided password matches the stored password for the user with the given phone number
        if (!existingPhoneEntity.getPassword().equals(loginEntity.getPassword())) {
            return "Invalid Password";
        }

        // Check if a user exists with the provided email ID
        SignupEntity existingEmailEntity = repository.findByEmailId(loginEntity.getEmailId());
        if (existingEmailEntity == null) {
            return "Invalid Email ID";
        }

        // If all checks pass, return success message
        return "Login Successful";
    }
}
