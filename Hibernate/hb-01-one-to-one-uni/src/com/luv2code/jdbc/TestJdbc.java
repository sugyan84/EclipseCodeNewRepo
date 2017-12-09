package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class TestJdbc
{

	static Logger log = Logger.getLogger(TestJdbc.class.getSimpleName());

	public static void main(String[] args)
	{
		log.info("main method");

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";

		String username = "hbstudent";
		String password = "hbstudent";

		try
		{
			System.out.println("Connecting to mySQL database...");

			Connection con = DriverManager.getConnection(jdbcUrl, username, password);

			// System.out.println("Connection successful");

			log.info("inf");

		}
		catch(Exception e)
		{

		}
	}

}
