<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import ="java.sql.*" %>
    <%@page import="connections.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Footwears</title>
<style>
div
{
display:inline-block;
margin:10px;
width:200px;
height:200px;
box-shadow:0px 0px 5px #aaa;
}
img
{
width:100%;
height:100%;
}
</style>
</head>
<body>
<h1>Our Footwear Collections</h1>
<%
Connection con=null;
ResultSet rs=null;
try
{
	con=ConnectionProvider.provideConnection();
	Statement s=con.createStatement();
	rs=s.executeQuery("select * from products");
	while(rs.next())
	{
%>
<div>
<img src="<%=rs.getString(3)%>">
</div>
<%
	}
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
	%>
</body>
</html>