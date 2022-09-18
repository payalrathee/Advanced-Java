<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.hibernate.SessionFactory" %>
    <%@page import="org.hibernate.Query" %>
    <%@page import="org.hibernate.Session" %>
    <%@page import="java.util.List" %>
    <%@page import="beans.Question" %>
<%@page import="connections.SessionFactoryProvider" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Questions</title>
    <link href="style.css" rel="stylesheet">
    <link href="display.css" rel="stylesheet">
    <style>
 

aside
{
    background-color: bisque;
    width:100%;
    height:15vh;
}
.wrapper
{
    margin:6%;
}
.ques-wrapper
{
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    /* background-color: pink; */
    width:80%;
    margin:auto;
    height:60vh;
    padding:4%;
    box-shadow: 0px 0px 5px #aaa;
    margin:2%;
}
.ques
{
    padding:2%;
    color:rgb(0, 0, 0);
}
.op{
    padding: 2%;
    color: gray;
}
    </style>
</head>

<body>
<%
SessionFactory factory=SessionFactoryProvider.provideSessionFactory();
Session s=factory.openSession();
Query q = s.createQuery("from Question");
List<Question> questions=q.list();
int totalQues=questions.size();
%>
 <form method="post" action="EvaluateServlet?totalQues=<%=totalQues %>" class="wrapper"> 
 <aside>
 <%
 for(int i=0;i<totalQues;i++)
 {
	 %>
	 <a href=<%="#"+i %>><%=i %></a>&nbsp;&nbsp;
	 <%
 }
 %>
<input class="button" type="submit" style="width:10%">
 </aside>
<% 
for(int i=0;i<totalQues;i++)
{
	%>
    	<a name=<%=i %>></a>
        <div class="ques-wrapper">
            <div class="ques text"><%=questions.get(i).getQues() %> : 
            <input type="hidden" name=<%="ques"+i %> value=<%=questions.get(i).getId() %>>
            </div>
            <div class="op text">
                <input type="radio" name=<%="op"+i %> value=<%=questions.get(i).getChoices().get(0).getId() %> ><%=questions.get(i).getChoices().get(0).getChoice() %><br>
            </div>
            <div class="op text">
                <input type="radio" name=<%="op"+i %> value=<%=questions.get(i).getChoices().get(1).getId() %>><%=questions.get(i).getChoices().get(1).getChoice() %><br>
            </div>
            <div class="op text">
                <input type="radio" name=<%="op"+i%> value=<%=questions.get(i).getChoices().get(2).getId() %>><%=questions.get(i).getChoices().get(2).getChoice() %><br>
            </div>
            <div class="op text">
                <input type="radio" name=<%="op"+i %> value=<%=questions.get(i).getChoices().get(3).getId() %>><%=questions.get(i).getChoices().get(3).getChoice() %><br>
            </div>
        </div>
        <%
}
%>
</form>
</body>

</html>


