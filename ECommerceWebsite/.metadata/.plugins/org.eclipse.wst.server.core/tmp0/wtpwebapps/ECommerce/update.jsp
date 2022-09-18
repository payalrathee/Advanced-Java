<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.UpdateProfileDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>
<jsp:useBean id="b" class="bean.SignUpBean"></jsp:useBean>
<jsp:setProperty property="*" name="b"/>
<%
boolean isUpdated=false;
if(session.getAttribute("user").equals("Admin"))
{
	isUpdated=UpdateProfileDao.updateAdminProfile(b, (String)session.getAttribute("email"));
}
else
{
	isUpdated=UpdateProfileDao.updateBuyerProfile(b,(String)session.getAttribute("email"));
}
if(isUpdated==false)
{
	%>
	<p style="background-color:red;">Failed to update your profile! Try again later.</p>
	<%
}
%>
<jsp:include page="profile.jsp"></jsp:include>

<%-- <%=b.getUsername() %>
<%=b.getFname() %>
<%=b.getLname() %>
<%=b.getMobile() %>
<%=b.getPwd() %>
<%=b.getEmail() %> --%>

</body>
</html>