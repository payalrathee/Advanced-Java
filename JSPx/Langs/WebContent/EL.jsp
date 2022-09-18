<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="p1.A" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="EL.jsp?name=payal" >click</a>

<%-- <%=request.getParameter("name") %>
<% session.setAttribute("name","payal");%>
 <%=session.getAttribute("name") %>
<input type="text" value="${'abc' }">
${2}
${3+5} --%>
<%
Cookie c=new Cookie("pwd","123");
response.addCookie(c);
Cookie c1=new Cookie("name","pay");
response.addCookie(c1);
Cookie c2=new Cookie("email","p@gmail.com");
response.addCookie(c2);
Cookie c3=new Cookie("addr","rtk");
response.addCookie(c3);
%> 
<%-- ${param["name"]} --%>

<%
String[] s={"a","b","c"};
pageContext.setAttribute("s",s);
%>
<c:forEach var="i" begin="0" end="4">
<c:out value="${s[i] }"/>
</c:forEach>
<c:forEach var="cook" items="${cookie }">
	<c:out value="${cook.key }"/> : <c:out value="${cook.value.value }"/><br>
</c:forEach>

<%session.setAttribute("place","India"); %>
${sessionScope["place"] }
<%request.setAttribute("color","purple"); %>
${requestScope["color"] }
<%=request.getParameter("color") %>
<%-- <jsp:useBean id="a" class="p1.A" scope="page"></jsp:useBean>
<jsp:setProperty property="x" name="a"/> --%>

</body>
</html>