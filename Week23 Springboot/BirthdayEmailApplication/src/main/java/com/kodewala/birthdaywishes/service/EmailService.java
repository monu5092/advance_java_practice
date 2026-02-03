package com.kodewala.birthdaywishes.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
      
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendBirthdayMail(String to,String name)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("🎉 Happy Birthday 🎂");
		message.setText("Dear " + name + ",\n\nWish you a very Happy Birthday 🎉🎂\nHave a wonderful year ahead!");
		mailSender.send(message);
	}
}
