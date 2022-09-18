package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connections.ConnectionProvider;

public class MailServlet extends HttpServlet {
	Connection con=null;
	public void init(ServletConfig c)
	{
		con=ConnectionProvider.provideConnection();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String email=request.getParameter("email");
		try
		{
			PreparedStatement s=con.prepareStatement("select password from users where email=?;");
			s.setString(1, email);
			ResultSet rs=s.executeQuery();
			
			PrintWriter w=response.getWriter();
			rs.next();
			final String pwd=rs.getString(1);
			w.println(pwd);
			
			//MAILING PART BEGIN
			
			//creating properties object
			Properties p=System.getProperties();
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.put("mail.smtp.auth", "true");
			p.put("mail.debug", "true");
			p.put("mail.smtp.port", "465");
			p.put("mail.smtp.socketFactory.port", "465");
			p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.put("mail.smtp.socketFactory.fallback", "false");
			
			//creating session
			Session session=Session.getDefaultInstance(p,
					new Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication("abc@gmail.com","xxx");
				}
			}
	);
			
			session.setDebug(true);
			try
			{
				MimeMessage msg=new MimeMessage(session);
				msg.setFrom(new InternetAddress("abc@gmail.com"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
				msg.setSubject("Forgot password");
				msg.setText("Your password is : "+pwd);
				
				Transport.send(msg);
				
			}
			catch(MessagingException e)
			{
				System.out.println(e);
			}
			
			
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	public void destroy()
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

}
