<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jstlSQL</title>
</head>
<body>
<sql:setDataSource var="con" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/ella" user="root" password="payal"/>
<sql:query dataSource="${con }" var="rs">
select * from admin where id=? and lname=?;
<sql:param>102</sql:param>
<sql:param>rathee</sql:param>
</sql:query>
<c:forEach var="row" items="${rs.rows }">
<c:out value="${row.id }"/>
<c:out value="${row.fname }"/>
<c:out value="${row.lname }"/>
<c:out value="${row.email }"/><br>
</c:forEach>
<sql:update dataSource="${con }" var="r">
update admin set fname=? where id=?;
<sql:param>bhanu</sql:param>
<sql:param>102</sql:param>
</sql:update>
${r }
</body>
</html>