package p1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UploadServlet2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appPath=getServletContext().getRealPath("");
		String path=appPath+File.separator+"uploadFile";
		File uploadFile=new File(path);
		if(!uploadFile.exists())
			uploadFile.mkdir();
		
		MultipartRequest mpr=new MultipartRequest(request,path,20*1024*1024);
		
		PrintWriter writer=response.getWriter();
		writer.println("done");
		writer.println("file is uploaded to "+path);
	}

}
