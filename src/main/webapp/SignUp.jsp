<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Page</title>
<style type="text/css">
	body {
	background-color: fuchsia;
}
</style>
</head>
<body>
<h1 align ="center">Signup</h1>
<form action="signupServlet" method="get">
<table align= "center" border="1" bgcolor="grey">
<tr>
<td>Name</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>Phone Number</td>
<td><input type="text" name="pnum"></td>
</tr>
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
<td><a href="login.jsp">User_Login</a></td>
</tr>
<tr>
<td><a href="AdminLogin.jsp">Admin_Login</a></td>
</tr>
</table>
</form>
</body>
</html>