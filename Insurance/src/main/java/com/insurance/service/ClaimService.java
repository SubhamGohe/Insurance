package com.insurance.service;

import java.util.List;
import java.util.Optional;

import com.insurance.model.Claim;

public interface ClaimService {
	public Claim saveClaim(Claim claim);
	public List<Claim> getAllClaims();
	 public Optional<Claim> getClaimById(Long id);
	 public void deleteClaim(Long id) ;
}
