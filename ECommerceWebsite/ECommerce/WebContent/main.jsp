<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dao.ViewDao" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>
<!-- <link href="utility.css" rel="stylesheet"> -->
<style>
#main
{
    width:100%;
    /* background-color: blueviolet; */
    position: absolute;
    top:93px;
}
#mainimg-wrapper
{
    width:90%;
    height:500px;
    margin:auto;
    background-image: url('shoeback.jpg');
    background-repeat: no-repeat;
    background-size: cover;
    display:flex;
    justify-content: center;
    align-items: flex-start;
}
#shopnow
{
    text-decoration: none;
    background-color: rgb(235, 66, 117);
    color:white;
    border-radius: 3px;
    padding:20px 60px;
    position: relative;
    top:200px;
    left:-400px;
}
#shopnow:hover{
    background-color: rgb(231, 112, 148);
    box-shadow: 0px 0px 5px rgb(247, 44, 105);
}


#items-wrapper
{
    width:70%;
    margin:auto;
}
.items
{
    display: inline-block;
    width:200px;
    height: 250px;
    margin:10px;
    border-radius: 5px;
    box-shadow:0px 0px 5px #aaa;
}
.items:hover
{
    box-shadow:0px 0px 8px rgb(4, 49, 51);
}
.img
{
    border-radius: 5px;
    height:100%;
    width:100%;
}
</style>
</head>
<body>
<%
ArrayList<ArrayList<String>> products=ViewDao.view();
%>
<main id="main">
        <div id="mainimg-wrapper">
            <span><a id="shopnow" href="#">Shop Now</a></span>
        </div>
        <div id="items-wrapper">
        <%
        for(int i=0;i<products.size();i++)
        {
        %>
            <span class="items">
                <img class="img" src="<%= products.get(i).get(2)%>">
            </span>
        <%} %>
        </div>
    </main>
</body>
</html>