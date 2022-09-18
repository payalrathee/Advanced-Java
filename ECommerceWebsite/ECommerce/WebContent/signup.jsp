<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.SignUpDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
<link href="utilities.css" rel="stylesheet">
<style>
body
{
    background-image: url('register.webp');
    background-repeat: no-repeat;
    background-size: cover;
}

form{
    position: absolute;
    top:200px;
    right:200px;
    width:30%;
    height: 340px;
}
.item
{
    display: inline-block;
    margin:8px;
    width:70%;
    height:20px;
}
.input
{
    margin:5px;
    width:90%;
}
#signup
{
    width:90%;
    margin: 5px;
}
#signup:hover
{
    background-color:rgb(226, 9, 74) ;
}

</style>
</head>
<body>
<form action="" method="post" class="forms">
        <span class="item">
            <input type="radio" name="user" value="Admin">
            <span class="itemx">Admin</span>
        </span><br>
        <span class="item">
            <input type="radio" name="user" value="Buyer">
            <span class="itemx">Buyer</span>
        </span><br>
        <input class="input inputs" type="text" name="username" placeholder="enter username"><br>
        <input class="input inputs" type="text" name="fname" placeholder="enter first name"><br>
        <input class="input inputs" type="text" name="lname" placeholder="enter last name"><br>
        <input class="input inputs" type="text" name="email" placeholder="enter your email"><br>
        <input class="input inputs" type="text" name="mobile" placeholder="enter your mobile no."><br>
        <input class="input inputs" type="password" name="pwd" placeholder="enter password"><br>
        <input class="input inputs" type="password" name="pwd" placeholder="confirm password"><br>
        <input id="signup" class="buttons" type="submit" value="SignUp"><br>
    </form>
    <jsp:useBean id="signupBean" class="bean.SignUpBean"></jsp:useBean>
    <jsp:setProperty property="*" name="signupBean"/>
    <%
    if(signupBean.getUsername()!=null)
    {
    	boolean isRegistered=false;
    	if(signupBean.getUser().equals("Admin"))
    		isRegistered=SignUpDao.registerAdmin(signupBean);
    	else
    		isRegistered=SignUpDao.registerBuyer(signupBean);
    	
    	if(isRegistered)
    	response.sendRedirect("index.jsp");
    }
    %>
</body>
</html>











