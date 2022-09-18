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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connections.ConnectionProvider;

public class LoginServlet extends HttpServlet {
	Connection con=null;
	public void init(ServletConfig config)
	{
		con=ConnectionProvider.provideConnection();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter w=response.getWriter();
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		try
		{
			PreparedStatement p=con.prepareStatement("select * from user where id=? & pwd=?");
			p.setString(1,id);
			p.setString(2,pwd);
			ResultSet rs=p.executeQuery();
			
			if(rs.next())
			{
				Cookie c1=new Cookie("id",id);
				Cookie c2=new Cookie("pwd",pwd);
				
				response.addCookie(c1);
				response.addCookie(c2);
				
				response.sendRedirect("index.html");
			}
			else
			{
				w.println("<html><body><h4 style=\"background-color:red; width:100%; height:20px;\">Login Failed. Try Again!</h4></body></html>");
				RequestDispatcher d=request.getRequestDispatcher("login.html");
				d.include(request, response);
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
