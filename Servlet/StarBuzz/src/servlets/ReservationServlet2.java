package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connections.ConnectionProvider;

public class ReservationServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	
	public ReservationServlet2() {
        super();
     }
    
	public void init(ServletConfig s)
	{
		con=ConnectionProvider.provideConnection();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phn=request.getParameter("mobile");
		String date=request.getParameter("date");
		//String time=request.getParameter("time");
		String adultNo=request.getParameter("adultNo");
		String childNo=request.getParameter("childNo");
		
		try
		{
			PreparedStatement p=con.prepareStatement("insert into reservation values(?,?,?,?,?,?);");
			p.setString(1, name);
			p.setString(2,email);
			p.setString(3, phn);
			p.setDate(4, Date.valueOf(date));
//			p.setTime(5, Time.valueOf(time));
			p.setInt(5, Integer.parseInt(adultNo));
			p.setInt(6, Integer.parseInt(childNo));
			
			int r=p.executeUpdate();
			RequestDispatcher rd;
			if(r>0)
			{
				rd=request.getRequestDispatcher("index.html");
				rd.forward(request, response);
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter writer=response.getWriter();
				writer.println("<html><body><h4 style=\"background-color:red; width:100%; height:20px;\">Reservation Failed. Try Again!</h4></body></html>");
				rd=request.getRequestDispatcher("reservation.html");
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
