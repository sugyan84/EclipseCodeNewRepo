package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo
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
			//Begin a transaction
			session.beginTransaction();
			
			//Fetch Student object
			Student theStud = session.get(Student.class, 5);
			
			//Delete using session.delete() method
			session.delete(theStud);
			
			
			//Commit transaction
			session.getTransaction().commit();
			
			
			
			
			
			
			
			//Deleting Multiple rows using Query
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			int i = session.createQuery("delete from Student s where lastName='sahu'").executeUpdate();
			
			System.out.println("No.of rows affected: "+i);
			
			
			session.getTransaction().commit();
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("oops");
			e.printStackTrace();
		}finally
		{
			factory.close();
		}

	}

}
