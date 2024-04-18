package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlety implementation interface Servlet
 */
public class ServletContext2 implements Servlet {
	ServletConfig config;

    public ServletContext2() {
        
    }

	public void init(ServletConfig config) throws ServletException {
		this.config=config;
	}

	public void destroy() {
		
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		
		return null; 
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter w=response.getWriter();
		w.println(config);
	}

}
