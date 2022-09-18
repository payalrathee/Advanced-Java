<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/math.tld" prefix="math" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sum</title>
</head>
<body>
<%
String num1=request.getParameter("num1");
String num2=request.getParameter("num2");
%>
<%="num1 is : "+num1 %><br>
<%="num2 is : "+num2 %><br>

<math:sum num2="<%=num1 %>" num1="<%=num2 %>"></math:sum>
</body>
</html>