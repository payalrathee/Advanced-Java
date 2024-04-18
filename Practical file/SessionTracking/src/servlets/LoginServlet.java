package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		
		String username=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		RequestDispatcher rd;
		
		if(username.equals("payal")&&pwd.equals("payal@123"))
		{
			HttpSession session=request.getSession();
			rd=request.getRequestDispatcher("WelcomeServlet");
			rd.forward(request, response);
		}
		else
		{
			writer.println("<p style=\"background-color:red\">Enter valid details!</p>");
			rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}

}
