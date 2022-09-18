<%@page import="org.hibernate.*"%>
<%@page import="beans.Note"%>
<%@page import="java.util.List"%>
<%@page import="connections.SessionFactoryProvider"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet">
<title>Notes</title>
</head>
<body>
	<div><%@include file="header.jsp"%></div>
	<h2 class="h2 my-3 mx-3">Your Notes :</h2>
	<div class="row">
		<div class="col-12">
			<%
				SessionFactory factory = SessionFactoryProvider.provideFactory();
				Session s = factory.openSession();
				Query q = s.createQuery("from Note");
				List<Note> notes = q.list();

				for (Note n : notes) {
			%>
			<div class="card my-3 mx-auto" style="width: 60rem; box-shadow:0px 0px 3px #aaa;">
				<div class="card-body">
				<img src="notes.png" style="height:60px;width:60px;">
					<h5 class="card-title h4"><%=n.getTitle()%></h5>
					<h6 class="card-subtitle mb-2 text-muted"><%=n.getDate()%></h6>
					<p class="card-text"><%=n.getContent()%></p>
					<a href="DeleteNoteServlet?id=<%=n.getId()%>" class="btn-danger p-2">Delete</a>
					<a href="updateNote.jsp?id=<%=n.getId() %>&title=<%=n.getTitle() %>&content=<%=n.getContent() %>" class="btn-primary p-2">Update</a>
				</div>
			</div>
			<%
				}
				s.close();
			%>
		</div>
	</div>
</body>
</html>