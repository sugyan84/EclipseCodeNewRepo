package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo
{

	public static void main(String[] args)
	{
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		// Use session object to save Java object to DB
		try
		{

			// Begin a transaction
			session.beginTransaction();

			// Fetch Object
			int suppliedId = 2;
			Instructor iFetched = session.get(Instructor.class, suppliedId);

			// delete the instructor
			if(iFetched != null)
				session.delete(iFetched);
			else
				System.out.println("No rows found for the given ID: " + suppliedId);

			// Commit transaction
			session.getTransaction().commit();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}

	}

}
