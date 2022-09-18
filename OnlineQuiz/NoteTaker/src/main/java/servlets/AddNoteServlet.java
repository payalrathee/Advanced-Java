package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import beans.Note;
import connections.SessionFactoryProvider;

public class AddNoteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory=SessionFactoryProvider.provideFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		System.out.println(session);
		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Date date=new Date();
		
		Note note=new Note(title,content,date);
		session.save(note);
		t.commit();
		session.close();
		
		RequestDispatcher rd=request.getRequestDispatcher("addNotes.jsp");
		rd.include(request, response);
		rd=request.getRequestDispatcher("toast.jsp");
		rd.include(request, response);
	}

}
