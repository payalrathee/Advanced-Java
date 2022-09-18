package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connections.ConnectionProvider;

public class ViewServlet extends HttpServlet {
	Connection con;
	
	public void init(ServletConfig config)
	{
		con=ConnectionProvider.provideConnection();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter w=response.getWriter();
		response.setContentType("text/html");
		
		try
		{
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from reservation");
			
			w.println("<table border=2px>");
			w.println("<tr><th>Name</th><th>Email</th><th>Mobile</th><th>Date</th><th>AdultNo</th><th>ChildNo</th></tr>");
			while(rs.next())
			{
				String name=rs.getString(1);
				String email=rs.getString(2);
				String mobile=rs.getString(3);
				Date date=rs.getDate(4);
				int adultNo=rs.getInt(5);
				int childNo=rs.getInt(6);
				w.println("<tr><td>"+name+"</td><td>"+email+"</td><td>"+mobile+"</td><td>"+date+"</td><td>"+adultNo+"</td><td>"+childNo+"</td></tr>");
				
			}
			
			w.println("</table>");
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

/*
 
 
 
 */



















