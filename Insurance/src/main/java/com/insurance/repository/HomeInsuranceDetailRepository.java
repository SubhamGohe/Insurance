package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.model.HomeInsuranceDetail;

public interface HomeInsuranceDetailRepository extends JpaRepository<HomeInsuranceDetail, Long> {

}
