package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo
{

	public static void main(String[] args)
	{
		// Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		// Use session object to save Java object to DB
		try
		{
			//Create Objects
			/*Instructor i = new Instructor("Sugyan", "sahu", "sugyan84@gmail.com");
			InstructorDetail insd = new InstructorDetail("www.youtube.co", "Java Coding");*/
			
			Instructor i = new Instructor("Ankush", "panda", "anks@gmail.com");
			InstructorDetail insd = new InstructorDetail("www.youtube.com/anks", "SAP");
			
			//Associate the dependencies
			i.setInstructorDetail(insd);			
			
			
			//Begin a transaction
			session.beginTransaction();
			

			//save the instructor
			System.out.println("Saving instructor: "+i);
			session.save(i);
			
			
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
