package servletBox;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("In doGet()");

		// Set response content type
		res.setContentType("text/html");

		// Fetching Request Parameters.
		String message = req.getParameter("firstname");

		// Actual logic goes here.
		PrintWriter out = res.getWriter();
		out.println("Welcome Mr.<h1>" + message + "</h1>");

		out.close();

		// handleRequest(request, response);

		ServletContext cont = getServletContext();
		Enumeration<String> e = cont.getAttributeNames();

		while (e.hasMoreElements())
		{
			System.out.println(e.nextElement() + ", ");
		}

		String arr = (String) cont.getInitParameter("Chutiya"); // Right one to access web.xml contents
		System.out.println("Arr=" + arr);

		// ServletCOnfig Accessing...
		ServletConfig conf = getServletConfig();
		String arr2 = conf.getInitParameter("BC");
		System.out.println("config param=" + arr2);

	}

}
