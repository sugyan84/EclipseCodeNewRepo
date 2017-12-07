package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo
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
			
			
			//Query the Students
			//select * from student
			List<Student> studList = session.createQuery("from Student").list();
			
			//select * from student where lastName='sahu'
			List<Student> studListLastName = session.createQuery("from Student where lastName='sahu'").list();
			
			
			//select * from student where email like 'luv%com'
			List<Student> studListLike = session.createQuery("from Student where email like 'luv%com%'").list();
			
			
			//Display the fetched data
			System.out.println("\n\n----------------All Students----------------\n");
			for(Student l: studList)
			{
				System.out.println(l);
			}
			
			
			System.out.println("\n\n----------------Students where lastName='sahu'----------------\n");
			for(Student l: studListLastName)
			{
				System.out.println(l);
			}
			
			
			System.out.println("\n\n----------------Students where email like 'luv%com%'----------------\n");
			for(Student l: studListLike)
			{
				System.out.println(l);
			}
			
			
			
			
			
			
			//Commit transaction
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{

		}finally {
			factory.close();
		}

	}

}
