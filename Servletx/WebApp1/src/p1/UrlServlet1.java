package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter w=response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		w.println("<a href=\" UrlServlet2?name="+name+"&pwd="+pwd+"  \">Click</a>");
	}

}
