package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo
{

	public static void main(String[] args)
	{
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		// Use session object to save Java object to DB
		try
		{

			// Create a Student obect
			Student stud = new Student("Daffy3", "duck3", "luv2code@gmail.com3");

			// Begin a transaction
			session.beginTransaction();

			// save the student object
			System.out.println(stud);
			session.save(stud);

			// Commit transaction
			session.getTransaction().commit();

			
			
			
			
			// Retrieving the object from DB
			System.out.println("Saved Student's generated ID: " + stud.getId());

			// Get new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve Student Object
			Student st = session.get(Student.class, stud.getId());
			
			System.out.println("Fetched Student: |"+st+"|");
			
			
			session.getTransaction().commit();

		}
		catch(Exception e)
		{

		}
		finally
		{
			factory.close();
		}

	}

}
