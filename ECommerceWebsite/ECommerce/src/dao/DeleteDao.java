package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.ProductBean;
import connections.ConnectionProvider;

public class DeleteDao {
	public static boolean deleteProduct(ProductBean b)
	{
		boolean isDeleted=false;
		Connection con=null;
		
		try
		{
			con=ConnectionProvider.provideConnection();
			PreparedStatement p=con.prepareStatement("delete from products where id=?;");
			p.setInt(1, b.getId());
			int r=p.executeUpdate();
			if(r>0)isDeleted=true;
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
		
		return isDeleted;
	}

}
