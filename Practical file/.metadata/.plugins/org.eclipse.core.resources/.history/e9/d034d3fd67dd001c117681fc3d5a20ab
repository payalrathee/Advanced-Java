package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleCalculatorServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		
		double a=Double.parseDouble(request.getParameter("inputA"));
		double b=Double.parseDouble(request.getParameter("inputB"));
		double result=0.0;
		String operation=request.getParameter("operation");
		
		switch(operation)
		{
		case "add":result=a+b;
		break;
		case "sub":result=a-b;
		break;
		case "mul":result=a*b;
		break;
		case "div":result=a/b;
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("SimpleCalculator.html");
		rd.include(request, response);
		writer.println("Result is : " + result);
		
	}

}
