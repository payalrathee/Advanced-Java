package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UploadServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		//String path=getServletContext().getRealPath("upload");
=======
		String path=getServletContext().getRealPath("upload");
>>>>>>> 7b85307 (initial commit)
		MultipartRequest r=new MultipartRequest(request,"D:\\COURSES\\3Java\\practice ee\\Servletx\\Uploading\\WebContent\\upload",20*1024*1024);
		response.getWriter().println((r.getParameter("name"))+"! Your file is uploaded successfully");
		
	}

}
