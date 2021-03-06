package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers()
	{
		// get current hibernate session
		Session s = sessionFactory.getCurrentSession();

		// create a query
		Query q = s.createQuery("from Customer order by firstName");

		// execute query and get the results
		List<Customer> resultList = q.list();

		// return list
		return resultList;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer c)
	{
		// get current hibernate session
		Session s = sessionFactory.getCurrentSession();

		// create a query
		// s.save(c); //Insert new record

		s.saveOrUpdate(c); // Insert if id is empty, Update if id is available.

	}

	@Override
	@Transactional
	public Customer getCustomer(int id)
	{
		Session s = sessionFactory.getCurrentSession();

		Customer customerFetchedFromDB = s.get(Customer.class, id);

		return customerFetchedFromDB;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id)
	{
		// get current hibernate session
		Session s = sessionFactory.getCurrentSession();

		Query q = s.createQuery("delete from Customer where id=:custId");
		
		q.setParameter("custId", id);
		
		q.executeUpdate();
	}

}
