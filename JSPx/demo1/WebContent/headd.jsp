<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#header
{
position:fixed;
top:0px;
}
</style>
</head>
<body>
<h1 id="header">Header</h1>
<%= request.getParameter("name")%>
</body>
</html>