package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connections.ConnectionProvider;

public class LoginServlet extends HttpServlet {
Connection con=null;
	
	public void init(ServletConfig s)
	{
		con=ConnectionProvider.provideConnection();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		try
		{
			PreparedStatement p=con.prepareStatement("select * from users where id=? and pass=?;");
			p.setInt(1, Integer.parseInt(id));
			p.setString(2, pwd);
			
			ResultSet rs=p.executeQuery();
			RequestDispatcher rd;
			if(rs.next())
			{
				HttpSession session=request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("pwd", pwd);
				response.sendRedirect("index.html");
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter writer=response.getWriter();
				writer.println("<html><body><h4 style=\"background-color:red; width:100%; height:20px;\">Please enter valid details</h4></body></html>");
				rd=request.getRequestDispatcher("login.html");
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
