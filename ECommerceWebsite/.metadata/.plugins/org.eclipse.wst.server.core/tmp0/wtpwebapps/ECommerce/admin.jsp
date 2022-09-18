<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ViewDao"%> 
<%@include file="header.jsp" %>
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
<link href="utilities.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
<style>
body{
   margin:0px;
    background-color: rgb(248, 237, 239);
}
main{
position:absolute;
top:93px;
width:100%;
padding:1px;
margin:2px;
}
#update-panel
{
    box-sizing: border-box;
    display: inline-block;
    width:29%;
    height:85vh;
    /* background-color: aqua; */
    vertical-align: top;
    padding:5px;
    margin:1px;
    box-shadow: 0px 0px 3px #aaa;
    background-color: white;
    border-radius: 5px;
}
.panel
{
    display: block;
    box-sizing: border-box;
    box-shadow:0px 0px 3px #aaa;
    padding:10px;
    margin: 5px;
    height:35%;
}
#update-panel .panel:last-of-type
{
height:27%;
}
.inputs{
padding:2px;
margin:5px 3px;
width:80%;
height:30px;
}
.buttons
{
width:68%;
margin:10px;
}
#shop-panel
{
    display: inline-block;
    width:69%;
    height:85vh;
    /* background-color: blueviolet; */
    vertical-align: top;
    padding:5px;
    box-sizing: border-box;
    margin:1px;
    box-shadow: 0px 0px 3px #aaa;
    background-color: white;
    border-radius: 5px;
    overflow:auto;
}
.items{
height:220px;
width:200px;
display:inline-block;
margin:10px;
box-shadow:0px 0px 3px #aaa;
}
.items:hover
{
box-shadow:0px 0px 10px #aaa;
}
img
{
width:100%;
height:80%;
}
.desc
{
color:rgb(235, 66, 117);
display:block;
padding:1px;
margin:2px;
}
</style>
</head>
<body>
<main>
<aside id="update-panel">
        <section class="panel">
            <h1>Add Product</h1>
            <form method="post" action="addProduct.jsp">
                <input type="text" name="price" placeholder="enter price" class="inputs"> <br>
                <input type="text" name="url" placeholder="enter url" class="inputs"><br>
                <input type="submit" value="Add" class="buttons">
            </form>
        </section>
        <section class="panel">
            <h1>Update Price</h1>
            <form method="post" action="updateProduct.jsp">
                <input type="text" name="id" placeholder="enter id" class="inputs"> <br>
                <input type="text" name="price" placeholder="enter new price" class="inputs"><br>
                <input type="submit" value="Update" class="buttons">
            </form>
        </section>
        <section class="panel">
            <h1>Delete Product</h1>
            <form method="post" action="deleteProduct.jsp">
                <input type="text" name="id" placeholder="enter id" class="inputs"> <br>
                <input type="submit" value="Delete" class="buttons">
            </form>
        </section>
    </aside>
    <div id="shop-panel">
	<%
	ArrayList<ArrayList<String>> products=ViewDao.view();
	%>
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
</main>

</body>
</html>