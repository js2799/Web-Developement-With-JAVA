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
<title>Admin Homepage</title>
<style type="text/css">
	body {
	background-color: lightblue;
}
</style>
</head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Quantity</th>
<th>Delete</th>
<th>Update</th>

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
		<td><a href="DeleteServlet?id=<%=rs.getInt(1)%>">Delete</a></td>
		<td><a href="UpdateProduct.jsp?id=<%=rs.getInt(1)%>">Update</a></td>	
	</tr>
<%
		}
	}
		catch(Exception e){
			e.printStackTrace();
		}
%>
	
</tr>
</body>
</html>