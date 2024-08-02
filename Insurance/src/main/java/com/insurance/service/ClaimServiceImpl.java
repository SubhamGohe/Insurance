package com.insurance.service;

import com.insurance.model.Claim;
import com.insurance.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository repository;

    
   
    
    public Claim saveClaim(Claim claim) {
        return repository.save(claim);
    }

    public List<Claim> getAllClaims() {
        return repository.findAll();
    }

    public Optional<Claim> getClaimById(Long id) {
        return repository.findById(id);
    }

    public void deleteClaim(Long id) {
        repository.deleteById(id);
    }
}
