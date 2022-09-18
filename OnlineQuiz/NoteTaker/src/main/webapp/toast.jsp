<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>toast</title>
<style>
#toast
{
animation-name:toast;
animation-duration:2s;

position:fixed;
bottom:0px;
background-color:#b3e5fc;
width:100%;
}
@keyframes toast{
0%{}
100%{visibility:hidden;}
}
</style>
</head>
<body>
<div id="toast">
<p style="text-align:center;">Your note is added successfully!</p>
</div>
</body>
</html>