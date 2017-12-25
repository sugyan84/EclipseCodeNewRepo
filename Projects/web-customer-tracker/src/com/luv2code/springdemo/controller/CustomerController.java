package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
	// Inject DAO class's obj
	/*
	 * @Autowired private CustomerDAO customerDAO;
	 */

	// Inject CustomerService
	@Autowired
	private CustomerService customerService;

	/* @RequestMapping("/list") */
	@GetMapping("/list")
	public String listCustomers(Model m)
	{
		// get customers from DB using customerService
		List<Customer> list = customerService.getCustomers();

		// add the customers into Model.
		m.addAttribute("customers", list);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model m)
	{
		// create model attribute to bind form data.
		Customer newCustomer = new Customer();

		m.addAttribute("newCustomer", newCustomer);

		return "customer-form";
	}

	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("newCustomer") Customer c)
	{
		customerService.saveCustomer(c);
		return "redirect:/customer/list";		//Re-directing the user to another link
	}
}
