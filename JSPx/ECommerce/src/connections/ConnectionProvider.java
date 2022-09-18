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
            Class.forName(DBInfo.DB_DRIVER).newInstance();
            con= DriverManager.getConnection(DBInfo.DB_URL,DBInfo.DB_USER,DBInfo.DB_PWD);
        }
        catch(Exception e)
        {
            System.out.println(e);
    }
        return con;

    }
}
