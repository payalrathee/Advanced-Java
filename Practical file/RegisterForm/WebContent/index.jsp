<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegisterForm</title>
</head>
<body>
<h1>Register</h1>
<form method="post" action="Register.jsp">
<input type="text" name="name" placeholder="enter your name"><br><br>
<input type="text" name="email" placeholder="enter your email"><br><br>
<input type="password" name="pwd" placeholder="enter password"><br><br>
<input type="password" name="pwd" placeholder="confirm password"><br><br>
<input type="submit" value="register">
</form>
</body>
</html>