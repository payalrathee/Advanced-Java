<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quiz-Ace SignUp</title>
<link href="style.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap"
	rel="stylesheet">
<style>
body {
	height: 100vh;
	overflow: hidden;
	background-position: center;
	background-image: url('bg.jpg');
	background-repeat: no-repeat;
	background-size: cover;
}

#signIn {
	position: absolute;
	top: 30px;
	right: 15px;
	font-size: 20px;
}

#login-wrapper {
	opacity: 0.9;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -60%);
	background-color: rgb(254, 254, 255);
	border-radius: 5px;
	box-shadow: 0px 0px 2px #aaa;
	width: 30%;
	height: 40vh;
	margin: auto;
	padding: 3%;
}

.accountType {
	margin: 8px;
}

#forgotPwd {
	position: absolute;
	right: 10%;
}

@media ( max-width :800px) {
	#login-wrapper {
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -60%);
		background-color: rgb(254, 254, 255);
		border-radius: 5px;
		box-shadow: 0px 0px 2px #aaa;
		width: 80%;
		height: 30vh;
		margin: auto;
		padding: 2%;
	}
}
</style>
</head>

<body>
	<div id="signIn">
		<a href="index.jsp" class="link">Sign In</a>
	</div>
	<form action="SignUpServlet"  method="post" id="login-wrapper">
		<div class="accountType">
			<input required type="radio" name="accountType" value="user" id="user">
			<label for="user" class="text">User</label>
		</div>
		<div class="accountType">
			<input required type="radio" name="accountType" value="admin" id="admin">
			<label for="user" class="text">Admin</label>
		</div>
			<input required class="input" type="text" placeholder="Enter your name" name="name">
			<input required class="input" type="text" placeholder="Enter your email" name="email">
			<input required class="input" type="text" placeholder="Enter mobile" name="mobile">
			<input required class="input" type="password" placeholder="Enter password" name="pwd">
			<input required class="input" type="password" placeholder="Confirm password">
			<input class="button" type="submit" value="Sign Up">
	</form>
</body>

</html>