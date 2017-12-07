package servletBox;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/Welcome")
public class Welcome extends HttpServlet
{

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session = req.getSession();
        String user = (String)session.getAttribute("user");
        
        	// Set response content type
     		res.setContentType("text/html");

     		// Fetching Request Parameters.
     		HttpSession s= req.getSession(false);
     		String message = (String) s.getAttribute("Username");

     		// Actual logic goes here.
     		PrintWriter out = res.getWriter();
     		out.println("Welcome Mr.<h3>" + message + "</h3>");

     		out.close();
	}

}
