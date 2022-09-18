<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<%@include file="main.jsp" %>
<%
    if(session.getAttribute("email")!=null)
    	{%>
    	<%@include file="dp.jsp" %>
    	<%}
    else
    	{
    	%>
    	<%@include file="SiginPart.jsp" %>
    	<%
    	}
    	%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ella</title>
<style>
#menu-item1
{
background-color:white;
}
</style>
<link href="utilities.css" rel="stylesheet">
</head>
<body>
</body>
</html>