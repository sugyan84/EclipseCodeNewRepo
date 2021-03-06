package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService
{
	// Inject CustomerDAO
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> getCustomers()
	{
		// delegating the call to customerDAO's getCustomers() method.
		return customerDAO.getCustomers();
	}

	@Override
	public void saveCustomer(Customer c)
	{
		customerDAO.saveCustomer(c);
	}

	@Override
	public Customer getCustomer(int id)
	{
		Customer customerFetchedFromDB = customerDAO.getCustomer(id);

		return customerFetchedFromDB;
	}

	@Override
	public void deleteCustomer(int id)
	{
		customerDAO.deleteCustomer(id);
	}

}
