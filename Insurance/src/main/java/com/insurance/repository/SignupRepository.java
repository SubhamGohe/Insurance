package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.SignupEntity;

@Repository
public interface SignupRepository extends JpaRepository<SignupEntity, Long> {

	SignupEntity findByEmailId(String emailId);

	SignupEntity findByPhoneNumber(String phoneNumber);

	SignupEntity findByPassword(String password);

	

	

}
