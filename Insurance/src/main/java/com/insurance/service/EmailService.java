package com.insurance.service;

import java.io.File;

public interface EmailService {
    //send email to person
	 public void sendeEmail(String to,String subject ,String message);

    //send email to multiple person
	void sendEmail(String []to,String subject ,String message);
	
	//sendEmail withHtml
	void sendEmailWithHtml(String to ,String subject ,String htmlcontent);
	
	void sendEmailWithFile(String to ,String subject ,String message,File file);
}
