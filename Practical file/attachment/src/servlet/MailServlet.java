package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MailServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		PrintWriter writer=response.getWriter();
		
		String to=email;
		String from="abc@gmail.com";
		String subject="Password Recovery";
		boolean isMailSent=sendAttachment(from,to,subject);
		if(isMailSent)
			writer.println("File Sent.");
		else
			writer.println("Some error occured. Please try again later.");
		
	}
	public boolean sendAttachment(String from,String to,String subject)
	{
		boolean isMailSent=false;
		String host="smtp.gmail.com";
		
		Properties p=new Properties();
		p.put("mail.smtp.host", host);
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.auth", "true");
		
		Session session=Session.getInstance(p,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from,"xxx");
			}
		});
		
		session.setDebug(true);
		
		try
		{
			MimeMessage m=new MimeMessage(session);
			m.setFrom(new InternetAddress(from));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			
			String path="C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg";
			MimeMultipart mime=new MimeMultipart();
			MimeBodyPart text=new MimeBodyPart();
			text.setText("This is your requested file.");
			MimeBodyPart file=new MimeBodyPart();
			File f=new File(path);
			file.attachFile(f);
			
			mime.addBodyPart(text);
			mime.addBodyPart(file);
			
			m.setContent(mime);
			
			Transport.send(m);
		
			
			isMailSent=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return isMailSent;
	}

}
