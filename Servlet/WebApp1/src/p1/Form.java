package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter w=response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		w.println("<body><form method=\"post\" action=\"Form2\">");
		w.println("<input name=\"name\" type=\"hidden\" value=\""+name+"\">");
		w.println("<input name=\"pwd\" type=\"hidden\" value=\""+pwd+"\">");
		w.println("<input type=\"submit\">");
		w.println("</form></body>");
		
		
	}

}
