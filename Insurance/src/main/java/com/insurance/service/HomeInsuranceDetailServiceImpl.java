package com.insurance.service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import com.insurance.model.HomeInsuranceDetail;
	import com.insurance.repository.HomeInsuranceDetailRepository;

	import java.util.List;

	@Service
	public class HomeInsuranceDetailServiceImpl implements HomeInsuranceDetailService {

	    @Autowired
	    private HomeInsuranceDetailRepository repository;

	    public void saveDetail(HomeInsuranceDetail detail) {
	        repository.save(detail);
	    }

	   
	}


