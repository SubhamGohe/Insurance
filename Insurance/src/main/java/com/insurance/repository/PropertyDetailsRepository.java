package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.model.PropertyDetailsEntity;

public interface PropertyDetailsRepository extends JpaRepository<PropertyDetailsEntity, Long> {

}
