package com.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.model.SignupEntity;
import com.insurance.repository.SignupRepository;
@Service
public class SignupServiceImpl implements SignupService {
	@Autowired
	 private SignupRepository signupRepository;

	@Override
	public void createAccount(SignupEntity signupEntity) {
		 signupRepository.save(signupEntity);		
	}

	
	

	
}
