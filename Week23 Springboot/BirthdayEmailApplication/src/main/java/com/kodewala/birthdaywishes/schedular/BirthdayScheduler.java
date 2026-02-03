package com.kodewala.birthdaywishes.schedular;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.kodewala.birthdaywishes.entity.User;
import com.kodewala.birthdaywishes.repository.UserRepository;
import com.kodewala.birthdaywishes.service.EmailService;

public class BirthdayScheduler {
     
	
	@Autowired
	
	private UserRepository userRepository;


	@Autowired
	private EmailService emailService;


	// Runs every day at 9 AM
	@Scheduled(cron = "0 0 9 * * ?")
	public void sendBirthdayEmails() {
	LocalDate today = LocalDate.now();
	List<User> users = userRepository.findByDob(today);


	for (User user : users) {
	emailService.sendBirthdayMail(user.getEmail(), user.getName());
	}


	System.out.println("Birthday emails sent for: " + today);
	}
}
