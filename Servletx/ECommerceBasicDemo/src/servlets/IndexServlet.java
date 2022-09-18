package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] loginInfo=request.getCookies();
		
		if(loginInfo!=null)
		{
			response.sendRedirect("shop1.html");
		}
		else
		{
			response.sendRedirect("login.html");
		}
	}

}
