package com.luv2code.hibernate.demo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.FourWheeler;
import com.luv2code.hibernate.demo.entity.TwoWheeler;
import com.luv2code.hibernate.demo.entity.UserDetails;
import com.luv2code.hibernate.demo.entity.Vehicle;

public class Demo
{

	public static void main(String[] args)
	{
		// Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(UserDetails.class)	
									.addAnnotatedClass(Vehicle.class)
									.addAnnotatedClass(TwoWheeler.class)
									.addAnnotatedClass(FourWheeler.class)
									.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		Transaction tx = null;
		
		// Use session object to save Java object to DB
		try
		{
			/*//Create Objects
			UserDetails user1 = new UserDetails("Sugyan");
			UserDetails user2 = new UserDetails("Ankush");
			
			//Associate the dependencies
			Vehicle v = new Vehicle("Car");
			Vehicle v2 = new Vehicle("helicopter");
			
			user1.setVeh(v);
			user2.setVeh(v2);
			
			
			//Begin a transaction
			session.beginTransaction();
			

			//save the instructor
			session.save(user1);
			session.save(user2);
			
			
			//Commit transaction
			session.getTransaction().commit();*/
			
			
			
			
			/*//Inheritance Strategy
			Vehicle v = new Vehicle("Car");
			
			Vehicle two = new TwoWheeler("cycle");
			two.setVehicle_name("Unicorn-cycle");
			
			Vehicle four = new FourWheeler("Ola");
			four.setVehicle_name("Indica");
			
			
			tx = session.beginTransaction();
			
			session.save(v);
			session.save(two);
			session.save(four);
			
			tx.commit();*/
			
			
			
			
			
			
			
			/*for(int i = 0; i < 10; i++)
			{
				UserDetails u = new UserDetails("User ka naam-"+(i+1));
				session.save(u);
			}
			
			tx.commit();
			session.close();*/
			
			
			
			
			
			
			/*tx = session.beginTransaction();
			System.out.println("creating query...");
			Query q = session.createQuery("from UserDetails pik where pik.id>=5");
			
			System.out.println("firing query...");
			List<UserDetails> l = q.list();
			System.out.println("list fetched ..."+l.size());
			
			
			for(UserDetails uu: l)
			{
				System.out.println(uu.getName());
			}
			
			tx.commit();
			session.close();*/
		
			
			
			
			
			//State changes of Objects
			
			/*Transaction tx = session.beginTransaction();
			
			UserDetails obj = new UserDetails();
			
			obj.setName("Test User");
			obj.setAge(25);
			
			session.save(obj);
			
			obj.setAge(26);
			obj.setName("Pankaj");
			
			tx.commit();
			session.close();*/
			
			
			
			//Named-Query
			
			tx = session.beginTransaction();
			
			Query q = session.getNamedQuery("UserDetails.byId");
			q.setInteger("userId", 5);
			
			List<UserDetails> l = q.list();
			
			for(UserDetails i: l)
			{
				System.out.println(i.getAge()+"---"+i.getName());
			}
			
			tx.commit();
			session.close();
			
		}
		catch(Exception e)
		{

		}finally
		{
			factory.close();
		}

	}

}
