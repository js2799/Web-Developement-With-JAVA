<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
<style type="text/css">
	body {
	background-color: aqua;
}
</style>
</head>
<body>
<h1>Session</h1>
Welcome <%=session.getAttribute("email") %>
<h2>Logout</h2>
<a href="LogoutServlet">Logout</a>
<table border="1">
<tr>
<th>ID</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Quantity</th>
<th>Add To Cart</th>

<%
	String Username = "root";
	String Password = "";
	String url = "jdbc:mysql://localhost/cec";
	String driver = "com.mysql.cj.jdbc.Driver";
	
	try{
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, Username, Password);
		Statement st = con.createStatement();
		String query= "select * from product";
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()){
%>
	<tr>
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><a href="AddCartProductServlet?id=<%=rs.getInt(1)%>&nm=<%=rs.getString(2)%>&pr=<%=rs.getString(3)%>&pq=<%=rs.getString(4)%>">AddToCart</a></td>	
	</tr>
<%
		}
	}
		catch(Exception e){
			e.printStackTrace();
		}
%>
	
</tr>
</table border="2">
<h1>View Cart</h1>
<table border="1">
<tr>
<td><a href="ViewCartProductServlet">View Cart</a></td>
<td><a href="BillServlet">Generate Bill</a></td>
</tr>
</table>
</body>
</html>