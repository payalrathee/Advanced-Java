package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;

/**
 * Application Lifecycle Listener implementation class MyRequestListener
 *
 */
public class MyRequestListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {
    	System.out.println("RequestStop");
    }

    public void contextInitialized(ServletContextEvent arg0) {
    	System.out.println("RequestStart");
    }
	
}
