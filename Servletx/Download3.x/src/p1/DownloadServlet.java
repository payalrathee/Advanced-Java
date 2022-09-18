package p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadServlet")
@MultipartConfig
public class DownloadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter writer=response.getWriter();
		String filename=request.getParameter("name");
		//writer.println(filename);
		
		ServletContext context=getServletContext();
		String path=context.getRealPath("")+File.separator+"upload"+File.separator+filename;
		File f=new File(path);
		FileInputStream is=new FileInputStream(f);
		
		String mimeType=context.getMimeType(path);
		if(mimeType==null)
			mimeType="application/octet-stream";
		response.setContentType(mimeType);
		
		String headerKey="Content-Disposition";
		String headerValue=String.format("attachment;filename=\"%s\"", filename);
		response.setHeader(headerKey, headerValue);
		
		OutputStream os=response.getOutputStream();
		
		byte[] content=new byte[4096];
		int bytesRead=-1;
		while((bytesRead=is.read(content))!=-1)
			os.write(content,0,bytesRead);
		
//		is.read(content);
//		for(byte b :content)
//		{
//			os.write(b);
//		}
//		is.close();
//		os.close();
	}

}
