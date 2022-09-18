package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Shop1Servlet")
public class Shop1Servlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(!session.isNew())
		{
			String[] laptops=request.getParameterValues("laptop");
			int total=0;
			for(String s:laptops)
			{
				total+=Integer.parseInt(s);
			}
			
			session.setAttribute("laptop",total);
			response.sendRedirect("shop2.html");
		}
	}

}
