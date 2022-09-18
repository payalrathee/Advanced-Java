package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Admin;
import beans.User;
import connections.SessionFactoryProvider;

public class SignInServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String accountType=request.getParameter("accountType");
		boolean isValidUser=false;
		
		SessionFactory factory=SessionFactoryProvider.provideSessionFactory();
		Session session=factory.openSession();
		
		if(accountType.equals("user"))
		{
			User user=session.get(User.class, email);
			if(user!=null&&user.getPwd().equals(pwd))
				isValidUser=true;
		}
		else
		{
			Admin admin=session.get(Admin.class, email);
			if(admin!=null&&admin.getPwd().equals(pwd))
				isValidUser=true;
		}
		
		if(isValidUser)
		{
			HttpSession httpSession=request.getSession();
			session.setProperty("email", email);
			response.sendRedirect("home.jsp");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			rd=request.getRequestDispatcher("loginError.jsp");
			rd.include(request, response);
		}
		
		
		
	}

}
