package com.insurance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.service.EmailService;


@SpringBootTest
public class EmailSenderTest {
	 @Autowired
	 private EmailService emailServic ;
@Test
void emailSender() {
	System.out.println("Hello email tester");
}
@Test
void emailSenderTest() {
	emailServic.sendeEmail("shashankgohe01@gmail.com", "Subject", "Message");
	//emailServic.sendeEmail("shashankgohe01@gmail.com", "Spring Boot Tester", "This is message for java ,spring boot terter application");
}
}
