package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.ProductBean;
import connections.ConnectionProvider;

public class UpdateDao {
	public static boolean updatePrice(ProductBean b)
	{
		boolean isPriceUpdated=false;
		Connection con=null;
		
		try
		{
			con=ConnectionProvider.provideConnection();
			PreparedStatement p=con.prepareStatement("update products set price=? where id=?;");
			p.setInt(1, b.getPrice());
			p.setInt(2, b.getId());
			int r=p.executeUpdate();
			if(r>0)isPriceUpdated=true;
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
		
		return isPriceUpdated;
	}

}
