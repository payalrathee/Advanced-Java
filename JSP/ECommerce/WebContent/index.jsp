<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShopZilla</title>
    <link href="index.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
</head>

<body>
    <header id="header">
        <div class="div" id="left">
            <h3 id="name">ShopZilla</h3>
        </div>
        <div class="div" id="right">
            <nav id="navbar">
                <ul id="list">
                    <li><a href="#">Contact us</a></li>
                    <li><a href="#">Fitness Calculator</a></li>
                    <li><a href="#">About us</a></li>
                    <li><a href="#">Home</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <div id="qoute">
        Treat yourself to a little retail therapy...
    </div>

    <main>
        <div id="form">
            <h2>Join us</h2>
            <fieldset>
                <legend><h3>Register</h3></legend>
                <form method="post" action="register.jsp">
                    <input placeholder="Enter your name" type="text">
                    <input placeholder="Enter your age" type="text">
                    <input placeholder="Enter your email" type="text">
                    <input placeholder="Enter your mobile no." type="text">
                    <input placeholder="Enter your address" type="text">
                    <input id="submit" type="submit" value="Submit">
                </form>
            </fieldset>
        </div>
    </main>

</body>
</html>