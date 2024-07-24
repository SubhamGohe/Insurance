package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.model.SignupEntity;


public interface SignupRepository extends JpaRepository<SignupEntity, Long> {

}
