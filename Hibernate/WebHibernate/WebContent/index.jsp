<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.RegisterDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<form action="index.jsp" method="post">
<input type="text" name="name" placeholder="enter name"><br><br>
<input type="text" name="email" placeholder="enter email"><br><br>
<input type="submit">
</form>

<jsp:useBean id="bean" class="bean.RegisterBean"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>
<%
if(bean.getName()!=null&&bean.getEmail()!=null)
{
	boolean isRegistered=RegisterDao.register(bean);
	if(isRegistered)
	{
		%>
		<%="done" %>
		<%
	}
}
%>
</body>
</html>
