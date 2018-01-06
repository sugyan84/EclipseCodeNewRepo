package com.kashsplit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kashsplit.models.LoginForm;

@Controller
@RequestMapping("/login")
public class GreetingController
{
	@RequestMapping("/trip")
	public String showLoginForm(Model m)
	{
		
		return "login2";
	}
	
	
	@RequestMapping("/processForm")
	public String processLoginForm(@ModelAttribute("loginForm") LoginForm form)
	{
		System.out.println("Username submitted is "+form.getUserName());
		System.out.println("Password submitted is "+form.getPassword());
		
		return "login";
	}
}
