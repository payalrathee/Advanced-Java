package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connections.ConnectionProvider;

public class AddServlet extends HttpServlet {
Connection con=null;
	
	public void init(ServletConfig s)
	{
		con=ConnectionProvider.provideConnection();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("id")!=null)
		{
			String name=request.getParameter("name");
			String price=request.getParameter("price");
			String url=request.getParameter("url");
			
			try
			{
				PreparedStatement p=con.prepareStatement("insert into product values(null,?,?,?);");
				p.setString(1, name);
				p.setInt(2,Integer.parseInt(price));
				p.setString(3, url);
				
				int r=p.executeUpdate();
				RequestDispatcher rd;
				if(r>0)
				{
					response.setContentType("text/html");
					PrintWriter writer=response.getWriter();
					writer.println("<html><body><h4 style=\"background-color:lightblue; width:100%; height:20px;\">Product added successfully!</h4></body></html>");
					rd=request.getRequestDispatcher("add.html");
					rd.include(request, response);
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter writer=response.getWriter();
					writer.println("<html><body><h4 style=\"background-color:red; width:100%; height:20px;\">Couldn't add the product. Try Again!</h4></body></html>");
					rd=request.getRequestDispatcher("add.html");
					rd.include(request, response);
				}
				
				
				
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
			
		}
		
		else
		{
			response.sendRedirect("login.html");
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
