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

public class DeleteServlet extends HttpServlet {
Connection con=null;
	
	public void init(ServletConfig s)
	{
		con=ConnectionProvider.provideConnection();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("id")!=null)
		{
			String id=request.getParameter("id");
			
			try
			{
				PreparedStatement p=con.prepareStatement("delete from product where id=?;");
				p.setInt(1, Integer.parseInt(id));
				
				int r=p.executeUpdate();
				RequestDispatcher rd;
				if(r>0)
				{
					response.setContentType("text/html");
					PrintWriter writer=response.getWriter();
					writer.println("<html><body><h4 style=\"background-color:lightblue; width:100%; height:20px;\">Product deleted successfully!</h4></body></html>");
					rd=request.getRequestDispatcher("delete.html");
					rd.include(request, response);
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter writer=response.getWriter();
					writer.println("<html><body><h4 style=\"background-color:red; width:100%; height:20px;\">Couldn't delete the product. Try Again!</h4></body></html>");
					rd=request.getRequestDispatcher("delete.html");
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
