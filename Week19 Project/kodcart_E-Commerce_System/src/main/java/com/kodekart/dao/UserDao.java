package com.kodekart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kodekart.model.User;

public class UserDao {
	
	private Connection connection = DBConnection.getConnection();
	
	public boolean register(User user)
	{
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO USERS(name,email,phone,password,role)values(?,?,?,?,?)"
					); 
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2,user.getEmail());
			preparedStatement.setString(3,user.getPhone());
			preparedStatement.setString(4,user.getPassword());
			preparedStatement.setString(5,user.getRole());
			return preparedStatement.executeUpdate() > 0;
		}
		catch(Exception e)
		{
			System.out.println("Registration failed: "+e.getMessage());
		}
		return false;
	}
	
	public User login(String email,String password) 
	{
	    User user = null;
	      try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					  "SELECT * FROM users WHERE email=? AND password=?");
			preparedStatement.setString(1,email);
			preparedStatement.setString(2, password);
			
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next())
			{
				user = new User();
	            user.setId(resultset.getInt("id"));
	            user.setName(resultset.getString("name"));
	            user.setEmail(resultset.getString("email"));
	            user.setPhone(resultset.getString("phone"));  
	            user.setPassword(resultset.getString("password"));
	            user.setRole(resultset.getString("role"));
			}
		  } 
	      catch (SQLException e) {
			e.printStackTrace();
		}
	    return user;
	}

}
