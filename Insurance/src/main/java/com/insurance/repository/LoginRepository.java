//package com.insurance.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.insurance.model.LoginEntity;
//@Repository
//public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
//
//	boolean existsByPhoneNumber(String phoneNumber);
//
//	boolean existsByEmailId(String emailId);
//
//	LoginEntity findByPhoneNumber(String phoneNumber);
//
//	LoginEntity findByPassword(String password);
//
//	LoginEntity findByEmailId(String emailId);
//
//}
