package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {
    	System.out.println("Stop");
    }

    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("Start");
    }
	
}
