package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.RegisterBean;
import connections.ConnectionProvider;

public class RegisterDao {

	public static boolean register(RegisterBean b)
	{
		boolean isRegistered=false;
		Connection con=null;
		
		try
		{
			con=ConnectionProvider.provideConnection();
			PreparedStatement p=con.prepareStatement("insert into user values(?,?,?);");
			p.setString(1, b.getName());
			p.setString(2, b.getEmail());
			p.setString(3, b.getPwd());
			int r=p.executeUpdate();
			if(r>0)
				isRegistered=true;
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
		
		return isRegistered;
	}
}
