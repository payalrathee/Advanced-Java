package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.SignUpBean;
import connections.ConnectionProvider;

public class UpdateProfileDao {

	public static boolean updateAdminProfile(SignUpBean b,String email)
	{
		boolean isUpdated=false;
		Connection con=null;
		
		try
		{
			con=ConnectionProvider.provideConnection();
			PreparedStatement p=con.prepareStatement("update admin set username=?,fname=?,lname=?,mobile=?,pwd=? where email=?;");
			p.setString(1, b.getUsername());
			p.setString(2, b.getFname());
			p.setString(3, b.getLname());
			p.setString(4, b.getMobile());
			p.setString(5, b.getPwd());
			p.setString(6, email);
			int r=p.executeUpdate();
			if(r>0)
				isUpdated=true;
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
		
		return isUpdated;
	}


public static boolean updateBuyerProfile(SignUpBean b,String email)
{
	boolean isUpdated=false;
	Connection con=null;
	
	try
	{
		con=ConnectionProvider.provideConnection();
		PreparedStatement p=con.prepareStatement("update buyers set username=?,fname=?,lname=?,pwd=?,mobile=? where email=?;");
		p.setString(1, b.getUsername());
		p.setString(2, b.getFname());
		p.setString(3, b.getLname());
		p.setString(4, b.getPwd());
		p.setString(5, b.getMobile());
		p.setString(6,email);
		int r=p.executeUpdate();
		if(r>0)
			isUpdated=true;
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
	
	return isUpdated;
}
}
