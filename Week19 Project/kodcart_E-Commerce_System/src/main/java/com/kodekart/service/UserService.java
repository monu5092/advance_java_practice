package com.kodekart.service;

import java.util.List;

import com.kodekart.dao.ProductDao;
import com.kodekart.dao.UserDao;
import com.kodekart.model.Product;
import com.kodekart.model.User;

public class UserService {
    
	private UserDao userDao = new UserDao();
	
	
	
	public boolean getRegister(User user) {
		return userDao.register(user);
	}
	
	public User getLogin(String email,String  password) {
		return userDao.login(email, password);
	}
     
}

     