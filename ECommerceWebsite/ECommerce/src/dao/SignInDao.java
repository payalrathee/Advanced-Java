package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.SignInBean;
import connections.ConnectionProvider;

public class SignInDao {
	
	public static int adminLogin(SignInBean b)
	{
		Connection con=null;
		int id=-1;
		
		try
		{
			con=ConnectionProvider.provideConnection();
			PreparedStatement p=con.prepareStatement("select * from admin where email=? and pwd=?;");
			p.setString(1,b.getEmail());
			p.setString(2,b.getPwd());
			ResultSet rs=p.executeQuery();
			if(rs.next())
			{
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
	
	public static int buyerLogin(SignInBean b)
	{
		int isBuyerValid=-1;
		Connection con=null;
		
		try
		{
			con=ConnectionProvider.provideConnection();
			PreparedStatement p=con.prepareStatement("select * from buyers where email=? and pwd=?;");
			p.setString(1,b.getEmail());
			p.setString(2,b.getPwd());
			ResultSet rs=p.executeQuery();
			if(rs.next())
				isBuyerValid=1;
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
		
		return isBuyerValid;
	}

}
