package com.kodewala.zepto.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/showLogin")
	public String showLogin()
	{
		System.out.println("LoginController.showLoginPage()::::::::::::::::::::::::::::::::::::::::::::");
		return "login";
	}
	
	@RequestMapping("/validateLogin")
	public String doLogin(@RequestParam("userName") String userName,@RequestParam("password") String Password)
	{
		System.out.println("LoginController.doLogin()::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(" User Name is ::: " + userName);
		System.out.println(" Password is ::: " + password);
		return "login-success";
	}
}
