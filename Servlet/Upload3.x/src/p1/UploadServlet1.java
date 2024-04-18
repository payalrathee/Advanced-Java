package p1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet1")
@MultipartConfig(maxFileSize=16177215)
public class UploadServlet1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter w=response.getWriter();
		String path=getServletContext().getRealPath("")+File.separator+"upload";
		w.println(path);

		for(Part p: request.getParts())
		{
			w.println("x");
			w.println(getFilename(p)+",");
			p.write(path+File.separator+getFilename(p));
		}
		
	}
	public String getFilename(Part part)
	{
		String contentDisp=part.getHeader("content-disposition");
		String[] items=contentDisp.split(";");
		for(String s : items)
		{
			if(s.trim().startsWith("filename"))
			{
				return s.substring(s.indexOf("=")+2,s.length()-1);
			}
		}
		return "";
	}
}
