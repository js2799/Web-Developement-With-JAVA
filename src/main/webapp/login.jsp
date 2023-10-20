<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style type="text/css">
	body {
	background-color: lightgreen;
}
</style>
</head>
<body>
<h1 align ="center">Login</h1>
<form action="loginServlet" method="get">
<table align= "center" border="1" bgcolor="grey">
<tr>
<td>Email Address</td>
<td><input type="email" name="email"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="pass"></td>
</tr>
<tr>
<td><input type="submit"></td>
</tr>
<tr>
<td><a href="SignUp.jsp">not registered user? Login</a></td>
</tr>
</table>
</form>
</body>
</html>