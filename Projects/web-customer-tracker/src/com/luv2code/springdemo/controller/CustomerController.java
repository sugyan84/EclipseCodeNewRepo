package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
	//Inject DAO class's obj
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model m)
	{
		//get customers from DB using customerDAO
		List<Customer> list = customerDAO.getCustomers();
		
		//add the customers into Model.
		m.addAttribute("customers", list);
		
		return "list-customers";
	}
}
