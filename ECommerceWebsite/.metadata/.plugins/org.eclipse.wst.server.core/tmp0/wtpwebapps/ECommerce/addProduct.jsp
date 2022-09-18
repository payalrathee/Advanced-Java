<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.AddDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<jsp:useBean id="productBean" class="bean.ProductBean"></jsp:useBean>
<jsp:setProperty property="*" name="productBean"/>
<%
boolean isAdded=AddDao.addProduct(productBean);
if(!isAdded)
{
%>
<p style="background-color:red">Failed to add the product! Please try again later.</p>
<%
}
%>
<jsp:include page="admin.jsp"></jsp:include>
</body>
</html>