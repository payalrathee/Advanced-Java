package listeners;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import connections.ConnectionProvider;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
public class MyContextListener implements ServletContextListener {
	Connection con=null;

    public void contextDestroyed(ServletContextEvent arg0) {
        try
        {
        	Statement s=con.createStatement();
        	s.executeUpdate("drop table a;");
        	System.out.println(con);
        	con.close();
        	
        }
        catch(SQLException e)
        {
        	System.out.println(e);
        }
    }

    public void contextInitialized(ServletContextEvent arg0) {
    	try
    	{
    		con=ConnectionProvider.provideConnection();
        	Statement s=con.createStatement();
        	s.executeUpdate("create table a(id int,name varchar(10));");
        	
    	}
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    }
	
}
