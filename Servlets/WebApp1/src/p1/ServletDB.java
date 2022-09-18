package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;   
    
    public ServletDB() {
        super();
     }
    public void init(ServletConfig c)
    {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","payal");
    	}
    	catch(Exception e){
    		System.out.print(e);
    	}
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		int r=-1;
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pass");
		String gender=request.getParameter("gender");		
		String date=request.getParameter("dob");
		int age=Integer.parseInt(request.getParameter("age"));
		String continent=request.getParameter("continent");
		
		try
		{
			PreparedStatement p=con.prepareStatement("insert into student2 values(?,?,?,?,?,?,?);");
			p.setString(1, name);
			p.setString(2, email);
			p.setString(3, pwd);
			p.setString(4, gender);
			p.setDate(5,Date.valueOf(date));
			p.setInt(6,age);
			p.setString(7, continent);
			
			r=p.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		if(r>0)
			writer.println("Updated succesfully!");
		else
			writer.println("Failed to update. Try again!");
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
//SimpleDateFormat f=new SimpleDateFormat("dd-MMM-yyyy");
//try { Date dob=f.parse(request.getParameter("dob"));}
//catch (ParseException e) { e.printStackTrace();}