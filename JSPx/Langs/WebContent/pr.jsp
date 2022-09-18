<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Practice</title>
</head>
<body>
<%-- <c:forEach var="i" begin="0" end="4">
<c:out value="${i+2 }"/>
</c:forEach> --%>

<form action="pr.jsp" method="post">
a: <input type="text" name="a">
<input type="submit" value="find">
</form>

<c:if test="${param.a!=null }">
<c:set var="flag" value="0"/>
<c:forEach var="i" begin="2" end="${param.a/2 }">
<c:if test="${param.a%i==0 }">
<c:set var="flag" value="1"/>
</c:if>
</c:forEach>
<c:choose>
<c:when test="${flag==0 }">prime</c:when>
<c:otherwise>not prime</c:otherwise>
</c:choose>
</c:if>

</body>
</html>