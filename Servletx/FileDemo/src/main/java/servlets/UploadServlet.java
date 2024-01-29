package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String appPath=getServletContext().getRealPath("");
		String path=appPath+File.separator+"uploadFile";
		File uploadFile=new File(path);
		if(!uploadFile.exists())
			uploadFile.mkdir();
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		MultipartRequest mpr = new MultipartRequest(request, path, 20*1024*1024);
		writer.print(path);
	}

}
