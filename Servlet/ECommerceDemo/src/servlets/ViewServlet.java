package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connections.ConnectionProvider;

public class ViewServlet extends HttpServlet {
Connection con=null;
	
	public void init(ServletConfig s)
	{
		con=ConnectionProvider.provideConnection();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("id")!=null)
		{
			PrintWriter w=response.getWriter();
			try
			{
				Statement p=con.createStatement();
				
				ResultSet r=p.executeQuery("select * from product;");
				w.println("<!DOCTYPE html><html lang=\"en\"><head><title>ShopZilla</title><style>h1{color:purple;margin:10px;padding:5px;}div{box-shadow:2px 2px 8px purple;display:inline-block;background-color: lavender;width:300px;height:500px;margin:20px;}span{display:block;margin:5px;padding:5px;}img{height:300px;width:100%;}</style></head><body>");
				w.println("<h1>Our Products</h1>");
				while(r.next())
				{
					w.println("<div><span>Name : "+r.getString(2)+"</span><span>Price :"+r.getInt(3)+"</span><span><img src=\""+r.getString(4)+"\"></span></div>");
				}
				
				w.println("</body></html>");
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
