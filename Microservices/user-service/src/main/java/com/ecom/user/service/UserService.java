package com.ecom.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.user.entity.Role;
import com.ecom.user.entity.User;
import com.ecom.user.exception.UserNotFoundException;
import com.ecom.user.repository.RoleRepository;
import com.ecom.user.repository.UserRepository;
import com.ecom.user.request.UserRequest;

import jakarta.transaction.Transactional;

@Service

public class UserService {
      
	 @Autowired
	 UserRepository userRepository;

	 @Autowired
	 RoleRepository roleRepository;
	
	 @Transactional
	 public User createUser(UserRequest request) {

		   if (request.getRoleName() == null || request.getRoleName().isBlank()) {
	            throw new RuntimeException("Role name must not be null or empty");
	        }
		 
	        Role role = roleRepository.findByRoleName(request.getRoleName())
	                .orElseGet(() -> {
	                    Role newRole = new Role();
	                    newRole.setRoleName(request.getRoleName());
	                    return roleRepository.save(newRole);
	                });

	        
	        User user = new User();
	        user.setName(request.getName());
	        user.setEmail(request.getEmail());
	        user.setRole(role);

	        
	        return userRepository.save(user);
	    }

	    public User getUserById(Long id) {
	        return userRepository.findById(id)
	                .orElseThrow(() ->
	                        new UserNotFoundException("User not found with id " + id));
	    }
}
