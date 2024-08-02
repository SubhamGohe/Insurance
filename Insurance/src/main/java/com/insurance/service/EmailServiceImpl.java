package com.insurance.service;

import java.io.File;
import java.nio.file.FileSystem;

import javax.management.RuntimeErrorException;

import org.eclipse.angus.mail.handlers.multipart_mixed;
import org.slf4j.LoggerFactory;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailMessage;
//import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
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
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		 simpleMailMessage.setTo(to);
		 simpleMailMessage.setSubject(subject);
		 simpleMailMessage.setText(message);
		 simpleMailMessage.setFrom("shashankcoder14@gmail.com");
		 
		 mailSender.send(simpleMailMessage);
		 logger.info("Email has been Send...");

	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlContent) {
	    MimeMessage mimeMessage = mailSender.createMimeMessage();
	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(htmlContent, true); // true indicates HTML content
	        helper.setFrom("shashankcoder14@gmail.com");

	        mailSender.send(mimeMessage);
	        logger.info("HTML email has been sent to {}", to);
	    } catch (MessagingException e) {
	        logger.error("Failed to send HTML email", e);
	        throw new RuntimeException("Failed to send HTML email", e);
	    }
	}
	 @Override
	    public void sendEmailWithFile(String to, String subject, String message, File file) {
	        MimeMessage mimeMessage = mailSender.createMimeMessage();
	        try {
	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true); // true for multipart
	            helper.setFrom("shashankcoder14@gmail.com"); // Corrected email domain
	            helper.setTo(to);
	            helper.setSubject(subject);
	            helper.setText(message, true); // true if message is HTML; use false for plain text
	            
	            // Attach the file
	            FileSystemResource fileSystemResource = new FileSystemResource(file);
	            helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
	            
	            // Send the email
	            mailSender.send(mimeMessage);
	            logger.info("Email sent to {} with subject: {}", to, subject);
	        } catch (MessagingException e) {
	            logger.error("Failed to send email with attachment", e);
	            throw new RuntimeException("Failed to send email with attachment", e);
	        }
	    }
	}


