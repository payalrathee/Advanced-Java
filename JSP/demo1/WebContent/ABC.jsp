<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" extends="demo1.A"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
#main{
position:relative;
top:100px;
}
</style>
<body>
<%@include file="header.html" %>
<div id="main">
<%= f()
%>
<%=session %><br>
<a href="two.jsp">click</a>
</div>
<%@include file="footer.html" %>
</body>
</html>