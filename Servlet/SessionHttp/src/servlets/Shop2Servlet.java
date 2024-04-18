package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Shop2Servlet")
public class Shop2Servlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(!session.isNew())
		{
			String[] dress=request.getParameterValues("dress");
			int total=0;
			for(String s:dress)
			{
				total+=Integer.parseInt(s);
			}
			
			session.setAttribute("dress",total);
			response.sendRedirect("logout.html");
		}
	}

}
