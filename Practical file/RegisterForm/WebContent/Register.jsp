<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dao.RegisterDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<jsp:useBean id="registerBean" class="beans.RegisterBean"></jsp:useBean>
<jsp:setProperty property="*" name="registerBean"/>
<%
boolean isRegistered=RegisterDao.register(registerBean);
if(isRegistered)
	out.println("You are successfully registered!");
else
	out.println("Rgisteration Failed! Try Again.");
%>
</body>
</html>