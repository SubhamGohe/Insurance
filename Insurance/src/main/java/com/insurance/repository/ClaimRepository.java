package com.insurance.repository;

import com.insurance.model.Claim;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

	Claim save(Claim claim);

	List<Claim> findAll();

	Optional<Claim> findById(Long id);

	void deleteById(Long id);

	
}
