<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital@1&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>header</title>
    <link href="style.css" rel="stylesheet">
    <style>
    header
    {
    position:fixed;
    width:100%;
    top:0px;
    z-index:1;
    background-color:white;
    height:100px;
    }
    #navbar
{

	width:100%;
    display:flex;
    justify-content: center;
    height:10vh;
    background-color:rgb(35, 171, 235);
}
#name
{
    position:fixed;
    top:2%;
    left:2%;
    font-weight: 600;
    font-size: 30px;
    color:white;
    font-family: 'Lora', serif;
    ;
}
.menu-items
{
    padding:30px 15px;
    color:white;
}

@media (max-width:700px)
{
    #navbar
{
    position:fixed;
    width:100%;
    top:55px;
    display:flex;
    justify-content: space-evenly;
    align-items: center;
    height:6vh;
}
#name
{
color:black;
}
}
    
    </style>
</head>
<body>
    <header>
    <div id="name">QUIZ-ACE</div>
    <nav id="navbar">
        <a href="#" id="menu-item1" class="link menu-items">Home</a>
        <a href="#" id="menu-item2" class="link menu-items">Quiz</a>
        <a href="#" id="menu-item3" class="link menu-items">Progress</a>
        <a href="#" id="menu-item4" class="link menu-items">About Us</a>
    </nav>
    </header>
</body>
</html>