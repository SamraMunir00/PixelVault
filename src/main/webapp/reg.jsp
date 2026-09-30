<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>portfolio </title>
    <link rel="stylesheet" href="reg_style.css">
</head>
<body>
	<form action="register" method="post" onsubmit="return validation()">
    <h1>Personal Photography Portfolio</h1>
    <div class="form">
        <div class="option">
            <button id="login">Login</button>
            <button id="reg">Register</button>
        </div>
        <div class="credentials">
            <p>Gmail</p>
            <input id="gmail" type="text" placeholder="john@gmail" name="gmail">
            <p>Password</p>
            <input id="password" type="password" placeholder="8 charcters long" name="password">
            <p>Confirm password</p>
            <input id="confirm" type="password" placeholder="Enter password again">

        </div>
        <div class="selection">
            <button id="submit" >Register</button>
         
        </div>
        
        
    </div>
	</form>
    <script type="text/javascript" src="reg_script.js"></script>
</body>
</html>