package com.kodewala.birthdaywishes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.birthdaywishes.entity.User;
import com.kodewala.birthdaywishes.repository.UserRepository;
import com.kodewala.birthdaywishes.schedular.BirthdayScheduler;

@RestController
@RequestMapping("/api/users")
public class UserController {
     
	@Autowired
	private UserRepository userRepository;


	@Autowired
	private BirthdayScheduler birthdayScheduler;


	
	@PostMapping
	public User addUser(@RequestBody User user) {
	return userRepository.save(user);
	}



	@GetMapping
	public List<User> getAllUsers() {
	return userRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
	return userRepository.findById(id).orElseThrow();
	}


	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
	userRepository.deleteById(id);
	return "User deleted successfully";
	}


	
	@PostMapping("/send-birthday-mails")
	public String triggerBirthdayEmails() {
	birthdayScheduler.sendBirthdayEmails();
	return "Birthday emails triggered successfully";
	}
}
