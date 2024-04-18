package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter w=response.getWriter();
		ServletContext ctx=getServletContext();
		
		HttpSession session=request.getSession();
		
		w.println("Total users:"+ctx.getAttribute("totalUsers"));
		w.println("Active users:"+ctx.getAttribute("activeUsers"));
	}
}
