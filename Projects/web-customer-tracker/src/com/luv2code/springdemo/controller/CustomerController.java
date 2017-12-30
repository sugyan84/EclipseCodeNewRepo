package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
	// Inject DAO class's obj
	/*
	 * @Autowired 
	 * private CustomerDAO customerDAO;
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
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model m)
	{
		//get the Customer model with id= "id" from DB.
		Customer customerFetched = customerService.getCustomer(id);
		
		//Bind the Model fetched from DB, to pre-populate the form.
		m.addAttribute("newCustomer", customerFetched);
		
		return "customer-form";
		
	}
	
	
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id)
	{
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";		//Re-directing the user to another link
	}
}
