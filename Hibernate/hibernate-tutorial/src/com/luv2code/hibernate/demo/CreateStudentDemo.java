package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo
{

	public static void main(String[] args)
	{
		// Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		// Use session object to save Java object to DB
		try
		{
			
			//Create a Student obect
			Student stud = new Student("Ankush", "panda", "anks@gmail.com");
			
			//Begin a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(stud);
			
			//Commit transaction
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{

		}finally
		{
			factory.close();
		}

	}

}
