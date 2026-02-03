package com.ecom.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.user.entity.User;
import com.ecom.user.request.UserRequest;
import com.ecom.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
     
	  @Autowired
	  UserService userService;
	  
	  @PostMapping("/create")
	  public ResponseEntity<User>createUser(@RequestBody UserRequest user)
	  {
		  return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
	  }
	  
	  @GetMapping("/{id}")
	  public ResponseEntity<User> getUser(@PathVariable Long id)
	  {
		return ResponseEntity.ok(userService.getUserById(id));  
	  }
}
