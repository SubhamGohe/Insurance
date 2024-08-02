package com.insurance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.service.EmailService;
import java.io.File;

@SpringBootTest
public class EmailSenderTest {
	 @Autowired
	 private EmailService emailService ;
@Test
void emailSender() {
	System.out.println("Hello email tester");
}
@Test
void emailSenderTest0() {
	emailService.sendeEmail("shashankgohe01@gmail.com", "Test For Email Sender", "This is message for email Sending api test");
	//emailServic.sendeEmail("shashankgohe01@gmail.com", "Spring Boot Tester", "This is message for java ,spring boot terter application");
}
@Test
void emailSenderTest1() {
	String[] recipients = {"shashankgohe01@gmail.com", "shashankgohe14@gmail.com","shashankdeveloper49@gmail.com"};
   emailService.sendEmail(recipients, "Subject Multipal Person", "Good Work");
}
@Test
void emailSenderTest2() {
    // Define the HTML content for the email
    String htmlContent = "<html>" +
            "<h1 style='color:red; border:1px solid red;'>Welcome to learn code with Shashank</h1>" +
            "</html>";

    // Call the method to send an email with HTML content
    emailService.sendEmailWithHtml("shashankgohe01@gmail.com", "Subject Html Code", htmlContent);
}
void sendEmailFile() {
	File file = new File("D:\\SHASHANK\\ALL DOCUMENT");
	
	emailService.sendEmailWithFile("shashankgohe01@gmail.com", "Subject For File check for ", "Message for File check",file );
}
}
