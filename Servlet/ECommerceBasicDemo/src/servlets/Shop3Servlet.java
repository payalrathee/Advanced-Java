package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Shop3Servlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] loginInfo=request.getCookies();
		
		if(loginInfo!=null)
		{
			String[] footwears=request.getParameterValues("footwear");
			int total=0;
			for(String s:footwears)
			{
				total+=Integer.parseInt(s);
			}

			Cookie c1=new Cookie("footwears",total+"");

			response.addCookie(c1);
			response.sendRedirect("result.html");
		}
	}

}
