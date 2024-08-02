package com.insurance.service;

import java.io.File;
import org.slf4j.LoggerFactory;
//import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
@Service
public class EmailServiceImpl implements EmailService {

	
	private JavaMailSender mailSender;
	
	 private  Logger logger = (Logger) LoggerFactory.getLogger(EmailServiceImpl.class);
  
	public EmailServiceImpl(JavaMailSender mailSender) {
//		super();
		this.mailSender = mailSender;
	}

	@Override
	public void sendeEmail(String to, String subject, String message) {
	     SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		 simpleMailMessage.setTo(to);
		 simpleMailMessage.setSubject(subject);
		 simpleMailMessage.setText(message);
		 simpleMailMessage.setFrom("shashankcoder14@gmail.com");
	    	
		 mailSender.send(simpleMailMessage);
		 logger.info("Email has been Send...");

	}

	@Override
	public void sendEmail(String[] to, String subject, String message) {
		

	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlcontent) {
		

	}

	@Override
	public void sendEmailWIthFile(String to, String subject, String message, File file) {
		

	}

}
