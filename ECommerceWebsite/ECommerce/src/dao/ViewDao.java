package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connections.ConnectionProvider;

public class ViewDao {

	public static ArrayList<ArrayList<String>> view()
	{
		ArrayList<ArrayList<String>> products=new ArrayList<ArrayList<String>>();
		Connection con=null;
		
		try
		{
			con=ConnectionProvider.provideConnection();
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from products;");
			while(rs.next())
			{
				ArrayList<String> p=new ArrayList<String>();
				p.add(rs.getInt(1)+"");//id
				p.add(rs.getInt(2)+"");//price
				p.add(rs.getString(3));//url
				
				products.add(p);
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
		
		return products;
	}
}
