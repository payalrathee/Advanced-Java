package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Shop2Servlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] loginInfo=request.getCookies();
		
		if(loginInfo!=null)
		{
			String[] dress=request.getParameterValues("dress");
			int total=0;
			for(String s:dress)
			{
				total+=Integer.parseInt(s);
			}

			Cookie c1=new Cookie("dress",total+"");

			response.addCookie(c1);
			response.sendRedirect("shop3.html");
		}
	}

}
