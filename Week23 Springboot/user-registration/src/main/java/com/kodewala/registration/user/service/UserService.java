package com.kodewala.registration.user.service;

import org.springframework.stereotype.Service;

import com.kodewala.registration.user.entity.User;
import com.kodewala.registration.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
    /* @Transactional is always implements in Service its not use with private method it give proxy error which call outside from the class
     * Its used for rollback and commit*/
    @Transactional
    public void registerUser(User user) {

        if (!"CONFIRM".equalsIgnoreCase(user.getConfirmPayment())) {
            throw new RuntimeException("Payment not confirmed → rollback");
        }        
        userRepository.save(user);

        System.out.println("User registered successfully");
    }

}
