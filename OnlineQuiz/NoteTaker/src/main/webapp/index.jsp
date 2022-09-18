<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link href="css/style.css" rel="stylesheet">
	<title>Index</title>
  </head>
  <body>
   <div><%@include file="header.jsp" %></div>
   <div class="container my-5 text-center">
   <img src="nt.png" style="height:300px;wwidth:300px;">
   <h2 class="h2 text-primary m-3 text-uppercase">Start taking your notes</h2>
   </div>
   <div class="container text-center my-5">
   <form action="addNotes.jsp">
   <input type="submit" value="Add Notes" class="btn-outline-primary p-2 my-5">
   </form>
   </div>
</body>
</html>