<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dao.ViewDao" %>
    <%@page import="java.util.ArrayList" %>
    <%@include file="header.jsp"%>
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
<title>Shop</title>
<link href="utilities.css" rel="stylesheet">
<style>
#items-wrapper {

width: 90%;
margin: auto;
position:absolute;
top:93px;
left:90px;
}
.items {
display: inline-block;
width: 200px;
height: 250px;
margin: 10px;
border-radius: 5px;
box-shadow: 0px 0px 5px #aaa;
}
.items:hover {
box-shadow: 0px 0px 8px rgb(4, 49, 51);
}
.img {
border-radius: 5px;
height: 80%;
width: 100%;
}
.desc
{
padding:2px;
margin:2px;
color:purple;
display:block;
text-align:center;
}
#menu-item3
{
background-color:white;
}
</style>
</head>
<body>
<%
ArrayList<ArrayList<String>> products=ViewDao.view();
%>
<div id="items-wrapper">
		<%
        for(int i=0;i<products.size();i++)
        {
        %>
    <div class="items">
        <img class="img" src="<%= products.get(i).get(2)%>">
        <span class="desc">Product Id : <%= products.get(i).get(0)%></span>
    	<span class="desc">Price : <%= products.get(i).get(1)%></span>
    </div>
    <%} %>
</div>

</body>
</html>