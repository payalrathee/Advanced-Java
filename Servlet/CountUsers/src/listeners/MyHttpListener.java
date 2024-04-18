package listeners;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent arg0) {
    	ServletContext ctx=arg0.getSession().getServletContext();
        Integer totalUsers=(Integer)ctx.getAttribute("totalUsers");
        if(totalUsers==null)
        	totalUsers=1;
        else
        	totalUsers++;
        
        Integer activeUsers=(Integer)ctx.getAttribute("activeUsers");
        if(activeUsers==null)
        	activeUsers=1;
        else
        	activeUsers++;
        
        ctx.setAttribute("totalUsers", totalUsers);
        ctx.setAttribute("activeUsers", activeUsers);
    	
    }

    public void sessionDestroyed(HttpSessionEvent arg0) {
    	ServletContext ctx=arg0.getSession().getServletContext();
        Integer activeUsers=(Integer)ctx.getAttribute("activeUsers");
        activeUsers--;
        ctx.setAttribute("activeUsers", activeUsers);
    }
	
}
