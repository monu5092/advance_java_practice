package com.kodewala.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kodewala.notification.dto.NotificationRequest;

@Service
public class NotificationService {
   
	 @Autowired
	 JavaMailSender javaMailSender;
	
	 public void sendEmail(NotificationRequest notificationRequest)
	 {
		 System.out.println("Sending email to "+notificationRequest.getEmail());
	 }
	
}
