package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.SignUpBean;
import connections.ConnectionProvider;

public class SignUpDao {
	public static boolean registerAdmin(SignUpBean b)
	{
		boolean isRegistered=false;
		Connection con=null;
		
		try
		{
			con=ConnectionProvider.provideConnection();
			PreparedStatement p=con.prepareStatement("insert into admin values(null,?,?,?,?,?,?,?);");
			p.setString(1,b.getUsername());
			p.setString(2,b.getFname());
			p.setString(3,b.getLname());
			p.setString(4,b.getMobile());
			p.setString(5,b.getEmail());
			p.setString(6,b.getPwd());
			p.setString(7,b.getDp());
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
	
	public static boolean registerBuyer(SignUpBean b)
	{
		boolean isRegistered=false;
		Connection con=null;
		
		try
		{
			con=ConnectionProvider.provideConnection();
			PreparedStatement p=con.prepareStatement("insert into buyers values(?,?,?,?,?,?,?);");
			p.setString(1,b.getEmail());
			p.setString(2,b.getUsername());
			p.setString(3,b.getFname());
			p.setString(4,b.getLname());
			p.setString(5,b.getMobile());
			p.setString(6,b.getPwd());
			p.setString(7,b.getDp());
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
