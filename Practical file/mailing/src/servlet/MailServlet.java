package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connections.ConnectionProvider;

public class MailServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		PrintWriter writer=response.getWriter();
		Connection con=null;
		String pwd=null;
		
		
		try
		{
			con=ConnectionProvider.provideConnection();
			PreparedStatement p=con.prepareStatement("select password from users where email=?;");
			p.setString(1, email);
			ResultSet rs=p.executeQuery();
			rs.next();
			pwd=rs.getString(1);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		
		
		String to=email;
		String from="abc@gmail.com";
		String subject="Password Recovery";
		String message="Your password is:"+pwd;
		boolean isMailSent=sendMail(from,to,subject,message);
		if(isMailSent)
			writer.println("Check your inbox for password");
		else
			writer.println("Some error occured. Please try again later.");
		
	}
	public boolean sendMail(String from,String to,String subject,String message)
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
			m.setText(message);
			
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
