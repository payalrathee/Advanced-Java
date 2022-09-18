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
<title>Index</title>
<style>
	#containerx
	{
	width:60%;
	margin:auto;
	margin-top:2%;
	}
</style>
</head>
<body>
	<div><%@include file="header.jsp"%></div>

	<div id="containerx">
		<form action="AddNoteServlet" method="post">
			<div class="form-group">
				<label for="title">Title</label>
				 <input
				 	required
					type="text" class="form-control"
					id="title"
					aria-describedby="emailHelp"
					placeholder="Enter title"
					name="title">
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				 <textarea
				 required
				 id="content"
				 class="form-control"
				 style="height:300px;"
				 placeholder="enter your notes"
				 name="content">
				 </textarea>
			</div>
			<div class="container text-center">
			<button type="submit" class="btn btn-primary">Add Note</button>
			</div>
		</form>
	</div>
</body>
</html>