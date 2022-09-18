package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Question;
import connections.SessionFactoryProvider;

public class EvaluateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalQues=Integer.parseInt(request.getParameter("totalQues"));
		int totalMarks=0;
		
		SessionFactory factory=SessionFactoryProvider.provideSessionFactory();
		Session session=factory.openSession();
		
		for(int i=0;i<totalQues;i++)
		{
			int quesId=Integer.parseInt(request.getParameter("ques"+i));
			int ansId=Integer.parseInt(request.getParameter("op"+i));
			
			Question q=session.get(Question.class,quesId);
			if(ansId==q.getAns().getId())
				totalMarks++;
		}
		
		response.getWriter().println("Total Marks : "+totalMarks);
	}

}
