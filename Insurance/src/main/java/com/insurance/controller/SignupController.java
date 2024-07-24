package com.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.SignupEntity;
import com.insurance.service.SignupService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api")
public class SignupController 
{
	@Autowired
	SignupService signupService;
	//localhost:8080/api/createAccount
	@PostMapping("/createAccount")
    public String creataAccount( @Valid @RequestBody SignupEntity signupEntity) 
 {
		signupService.createAccount(signupEntity);
	   return null;
 }
}
