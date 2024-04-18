package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connections.ConnectionProvider;

public class RegisterServlet extends HttpServlet {
Connection con=null;
	
	public void init(ServletConfig s)
	{
		con=ConnectionProvider.provideConnection();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		try
		{
			PreparedStatement p=con.prepareStatement("insert into users values(?,?,?,?);");
			p.setInt(1, Integer.parseInt(id));
			p.setString(2, pwd);
			p.setString(3,email);
			p.setString(4, mobile);
			
			int r=p.executeUpdate();
			RequestDispatcher rd;
			if(r>0)
			{
				response.sendRedirect("index.html");
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter writer=response.getWriter();
				writer.println("<html><body><h4 style=\"background-color:red; width:100%; height:20px;\">Reservation Failed. Try Again!</h4></body></html>");
				rd=request.getRequestDispatcher("register.html");
				rd.include(request, response);
			}
			
			
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}
	
	public void destroy()
	{
		try
		{
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
}
