<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Core Tags</title>
</head>
<body>
<%response.setContentType("text/html"); %>

<%-- <c:import var="data" url="http://www.google.com"/>  
<c:out value="${data}"/>  --%>
 
 
 <%-- <c:set var="amount" scope="page" value="${2000*3 }"></c:set>
 <c:out value="amount: ${amount }"></c:out><br>
 <c:remove var="amount" scope="page"/>
 <c:out value="amount : ${amount }"/>
  --%>
 <%-- amount : ${amount } --%>
 
 <%-- <c:catch var="e">
 <%int x=2/0; %>
 </c:catch>
 <c:if test="${e!=null }">
 <c:out value="${e }"></c:out>
 </c:if><br>
 hello  --%>
 
 <%-- <c:set var="x" value="11"/>
 <c:if test="${x==10 }">
 It is 10.
 </c:if><br>
 <c:choose>
 <c:when test="${x==10 }">It is 10.</c:when>
 <c:otherwise>It is not 10.</c:otherwise>
 </c:choose> --%>
 
 <%-- <c:forEach begin="0" end="3" var="i">
 ${i }&nbsp;
 </c:forEach>
 <%String[] s={"p","a","y","a","l"} ;
 session.setAttribute("s",s);%>
 <c:forEach var="j" items="${sessionScope.s}">
 ${j }&nbsp;&nbsp;&nbsp;&nbsp;
 </c:forEach> --%>
 
 <%-- <c:forTokens var="token" items="payal-rathee-bhanu-rathee" delims="-">
 <c:out value="${token }"/><br>
 </c:forTokens> --%>
 
 <%-- <c:redirect url="x.jsp">
 <c:param name="name" value="payal"/>
 </c:redirect> --%>
 
 <c:url value="EL.jsp"/>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
</body>
</html>