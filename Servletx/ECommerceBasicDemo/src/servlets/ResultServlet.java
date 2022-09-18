package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter w=response.getWriter();
		response.setContentType("text/html");
		
		Cookie[] loginInfo=request.getCookies();
		if(loginInfo!=null)
		{
			Cookie[] items=request.getCookies();
			int total=0;
			for(Cookie c:items)
			{
				if(!c.getName().equals("id")&&!c.getName().equals("pwd"))
				{
					w.println(c.getName()+" : "+c.getValue());
					total+=Integer.parseInt(c.getValue());
				}
			}
			w.println("<h2>Your Total Amount : "+total+"</h2>");
			w.println("<a href=\"LogoutServlet\">Logout</a>");
		}
		
	}

}
