<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.SignUpBean" %>
<%@ page import="dao.ProfileDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyProfile</title>
<link href="utilities.css" rel="stylesheet">
<style>
body
{
padding:0px;
}
aside
{
    width:30%;
    height:80vh;
    display:inline-block;
    box-shadow: 0px 0px 3px #aaa;
    background-color: white;
    border-radius: 10px;
    padding:20px;
    box-sizing: border-box;
    margin:10px 20px;
    position:absolute;
    top:100px;
}
.profile-details
{
    /* background-color: aqua; */
    color:rgb(250, 126, 147);
    display: block;
    width:60%;
    text-align:center;
    margin:auto;
    padding:10px;
}
#profile-pic
{
    height:150px;
    width:150px;
    border-radius: 30px;
    display: block;
    margin:auto;
    box-shadow: 0px 0px 3px black;
}

main
{
    width:60%;
    height: 80vh;;
    display: inline-block;
    background-color: white;
    box-shadow: 0px 0px 3px #aaa;
    border-radius: 10px;
    padding:20px;
    box-sizing: border-box;
    position:absolute;
    top:110px;
    left:33%;
}
legend{
    color:rgb(250, 91, 117);
    font-size:20px;
}
fieldset
{
	border:none;
    box-shadow:0px 0px 3px #aaa;
    margin:10px 20px;
    padding:20px;
}
input{
    width:60%;
    height: 26px;
    display: block;
    margin:auto;
}
</style>
</head>
<body>
<%!
String email;
SignUpBean b;
%>
<%
email=(String)session.getAttribute("email"); 
if(session.getAttribute("user").equals("Admin"))
	b=ProfileDao.fetchAdminData(email);
else
	b=ProfileDao.fetchBuyerData(email);
%>

<%@include file="header.jsp"%>
<jsp:include page="dp.jsp"></jsp:include>
<aside>
        <img id="profile-pic" src="<%= b.getDp()%> ">
        <span class="profile-details"><%=b.getUsername() %></span>
        <span class="profile-details"><%=b.getFname()+" "+b.getLname() %></span>
        <%
        if(session.getAttribute("user").equals("admin"))
        	{
       		%>
       		<span class="profile-details"><%=b.getId() %></span>
       		<%
       		}
       	%>
        <span class="profile-details"><%=b.getEmail() %></span>
    </aside>
    <main>
        
            <form action="update.jsp" method="post">
                <fieldset>
                    <legend>General</legend>
                    <input class="input inputs" type="text" name="username" value="<%= b.getUsername()%> " placeholder="Username"><br>
                    <input class="input inputs" type="text" name="fname" value="<%= b.getFname()%>" placeholder="First name"><br>
                    <input class="input inputs" type="text" name="lname" value="<%= b.getLname()%>" placeholder="Last name"><br>
                </fieldset>
            
                <fieldset>
                    <legend>Contact</legend>
                    <input class="input inputs" type="text" name="mobile" value="<%= b.getMobile()%>" placeholder="Mobile"><br>
                    <input disabled class="input inputs" type="text" name="email" value="<%= b.getEmail()%>" placeholder="Email"><br>
                </fieldset>
                <fieldset>
                    <legend>Security</legend>
                    <input class="input inputs" type="password" name="pwd" value="<%= b.getPwd()%>" placeholder="Password"><br>
                </fieldset><br>
                 <input class="input buttons" type="submit" value="Save Changes">
            </form>
    </main>
</body>
</html>