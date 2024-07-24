package com.insurance.service;


import org.springframework.http.ResponseEntity;

import com.insurance.model.SignupEntity;

public interface SignupService 
{
  
	public String createAccount(SignupEntity signupEntity);
  }
