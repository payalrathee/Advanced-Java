package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connections.ConnectionProvider;
import beans.RegisterBean;

public class RegisterDao {
	
	public static int register(RegisterBean b)
	{
		int id=-1;
		Connection con=null;
		
		try
		{
			con=ConnectionProvider.provideConnection();
			PreparedStatement p=con.prepareStatement("insert into users values(null,?,?,?);");
			p.setString(1, b.getName());
			p.setString(2,b.getAddress());
			p.setString(3, b.getMobile());
			
			int r=p.executeUpdate();
			if(r>0)
			{
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery("select max(id) from users;");
				rs.next();
				id=rs.getInt(1);
			}
			
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally
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
		
		return id;
	}

}
