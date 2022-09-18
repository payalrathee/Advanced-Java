package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.ProductBean;
import connections.ConnectionProvider;

public class AddDao {

	public static boolean addProduct(ProductBean b)
	{
		boolean isProductAdded=false;
		Connection con=null;
		
		try
		{
			con=ConnectionProvider.provideConnection();
			PreparedStatement p=con.prepareStatement("insert into products values(null,?,?);");
			p.setInt(1, b.getPrice());
			p.setString(2, b.getUrl());
			int r=p.executeUpdate();
			if(r>0)isProductAdded=true;
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
		
		return isProductAdded;
	}
}
