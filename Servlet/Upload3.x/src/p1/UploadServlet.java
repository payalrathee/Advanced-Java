package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
@MultipartConfig(maxFileSize=16177215)
public class UploadServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart=request.getPart("file");
		filePart.write("D:\\COURSES\\3Java\\practice ee\\Servletx\\Upload3.x\\WebContent\\upload\\a.html");
		response.getWriter().println("done");
	}

}
