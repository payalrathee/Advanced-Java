<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="beans.Topic"%>
<%@page import="connections.SessionFactoryProvider"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link href="style.css" rel="stylesheet">
<style>
main {
	width: 100%;
	position: absolute;
	top: 150px;
}

#items-wrapper {
	width: 90%;
	margin: auto;
	display: grid;
	grid-template-columns: auto auto auto auto auto;
	grid-gap: 1%;
}

.item {
	box-sizing:border-box;
 	padding:10px;
	width: 200px;
	height: 200px;
	display: inline-block;
	background-color:rgb(248, 252, 255);
	border-radius: 5px;
	box-shadow: 0px 0px 3px #aaa;
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
}

.item:hover {
	box-shadow: 0px 0px 8px #aaa;
	transform: scale(1.02);
}

.topic-desc
{
color:black;
font-size:20px;
}
@media ( max-width :600px) {
	#items-wrapper {
		grid-template-columns: auto;
		grid-gap: 1%;
	}
	.item {
		width: 100%;
	}
}

@media ( min-width :600px) and (max-width:800px) {
	#items-wrapper {
		grid-template-columns: auto auto auto;
	}
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		SessionFactory factory = SessionFactoryProvider.provideSessionFactory();
		Session s = factory.openSession();
		Query q = s.createQuery("from Topic");
		List<Topic> topics = q.list();
	%>
	<main>
	<div id="items-wrapper">
		<%
		for (int i = 0; i < topics.size(); i++) {
			%>
			<a href="index.jsp">
				<div class="item"><p class="topic-desc"><%=topics.get(i).getName() %></p></div>
			</a>
			<%
			}
		%>
		<a href="SignOutServlet">SignOut</a>
	</div>
	</main>
</body>
</html>






