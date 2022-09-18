package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection provideConnection()
    {
        Connection con=null;
        try
        {
            
            con= DriverManager.getConnection(DBInfo.DB_URL,DBInfo.DB_USER,DBInfo.DB_PWD);
            return con;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        return con;
    }

    }
}
