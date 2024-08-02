package com.insurance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.test.pack.Sum;

@SpringBootTest
class InsuranceApplicationTests {

	@Test
	void contextLoads() {
		Sum obj = new Sum();
		int sum = obj.sum(10, 20);
		System.out.println(sum);
		
		System.out.println("Hello Test");
	}

}
