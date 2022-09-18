package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownlaodServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/octet-stream");
		String filename=request.getParameter("filename");
		File f=new File(filename);
		String fname=f.getName();
		response.setHeader("content-disposition","attachment;filename=hfj.pdf");
		
		OutputStream out=response.getOutputStream();
		String path="D:\\COURSES\\3Java\\practice ee\\Servletx\\DownloadProject\\WebContent\\files\\hfj.pdf";
		FileInputStream fin=new FileInputStream(path);
		byte b[]=new byte[fin.available()];
		fin.read(b);
		out.write(b);
		out.close();
		fin.close();
	}

}
