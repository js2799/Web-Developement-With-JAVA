<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<style type="text/css">
	body {
	background-color: lightgreen;
}
</style>
</head>
<body>
<h1 align="center">Add Products</h1>
<form action="ProductServlet" method="get">
<table align= "center" border="1" bgcolor="lime">
<tr>
<td>Product Name</td>
<td><input type="text" name="pnm"></td>
</tr>
<tr>
<td>Product Price</td>
<td><input type="text" name="price"></td>
</tr>
<tr>
<td>Product Quantity</td>
<td><input type="text" name="pqua"></td>
</tr>
<tr>
<td><input type="submit"></td>
</tr>
<tr>
<td><a href="AdminHomepage.jsp">Display Product Page</a></td>
</tr>
</table>
</form>
</body>
</html>