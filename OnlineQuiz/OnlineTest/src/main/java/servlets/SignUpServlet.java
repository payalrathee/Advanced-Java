package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.User;
import beans.Admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connections.SessionFactoryProvider;

public class SignUpServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String pwd=request.getParameter("pwd");
		String accountType=request.getParameter("accountType");
		
		SessionFactory factory=SessionFactoryProvider.provideSessionFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		if(accountType.equals("user"))
		{
			User user=new User(name,email,mobile,pwd);
			session.save(user);
		}
		else
		{
			Admin admin=new Admin(name,email,mobile,pwd);
			session.save(admin);
		}
		
		t.commit();
		session.close();
		response.sendRedirect("index.jsp");
	}

}
