package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import beans.Note;
import connections.SessionFactoryProvider;

public class DeleteNoteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		SessionFactory factory=SessionFactoryProvider.provideFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		Note note=(Note)session.get(Note.class, id);
		session.delete(note);
		
		t.commit();
		session.close();
		response.sendRedirect("showNotes.jsp");
	}

}
