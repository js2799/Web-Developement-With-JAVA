<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product Page</title>
<style type="text/css">
	body {
	background-color: fuchsia;
}
</style>
</head>
<body>
<%String id = request.getParameter("id"); %>
<h1 align="center">Update Products</h1>
<form action="UpdateProductServlet" method="get">
<table align= "center" border="1" bgcolor="lime">
<tr>
<td>Product Name</td>
<td><input type="text" name="upnm"></td>
</tr>
<tr>
<td>Product Price</td>
<td><input type="text" name="uprice"></td>
</tr>
<tr>
<td>Product Quantity</td>
<td><input type="text" name="upqua"></td>
</tr>
<tr>
<td><input type="submit"></td>
<td><input type="hidden" name="id" value="<%=id %>" ></td>
</tr>
</table>
</form>
</body>
</html>