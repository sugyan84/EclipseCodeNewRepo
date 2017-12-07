package servletBox;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		String user=request.getParameter("Username");
		String pass= request.getParameter("Password");
		
		
		
		if(pass.equals("1234"))
        {
            //creating a session
			System.out.println("Password correct");
            HttpSession session = request.getSession();
            session.setAttribute("Username", user);
            RequestDispatcher rd = request.getRequestDispatcher("Welcome");
            rd.include(request, response);
        }
	}

}
