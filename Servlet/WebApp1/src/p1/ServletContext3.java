package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContext3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter w=response.getWriter();
		ServletContext context=getServletContext();
		w.println(context);
		Integer count=(Integer)context.getAttribute("count");
		if(count==null)
			count=0;
		count++;
		context.setAttribute("count", count);
		w.println("No of requests for this web app are :"+count);
		
	}

}
