<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.dto.User"%>
<%@page import="java.lang.*" %>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<%
List<User> list=new ArrayList<User>();
if(session.getAttribute("list")!=null){
	 list=(ArrayList<User>)session.getAttribute("list");
}
else{
	//System.out.println("User is null");
}%>

<title>Delete</title>
</head>
<body>
	<h1 align="center">User Detail</h1>
	<form action="Delete" method="get">
		<table border="1px">
			<tr>
				<td colspan="12">List Of User Detail</td>
				<td><input type="submit" name="buttonaction" value="Delete"></td>
				<td><input type="submit" name="buttonaction" value="DeleteAll"></td>
			</tr>
			<tr>
			<td></td>
				<td>Name</td>
				<td>Age</td>
				<td>DOB</td>
				<td>Language</td>
				<td>Gender</td>
				<td>Username</td>
				<td>Password</td>
				<td>Email</td>
				<td>Contact</td>
				<td>Address</td>
				<td>Type</td>
				<td></td>
			</tr>
			<%for(User u:list){ %>
			<tr>
			<td><input type="checkbox" name="rowKey" id="rowKey" value=<%=u.getUsername()%>></td>
				<td><%=u.getName()%></td>
				<td><%=u.getAge()%></td>
				<td><%=u.getDob()%></td>
				<td><%=u.getLang()%></td>
				<td><%=u.getGender()%></td>
				<td><%=u.getUsername()%></td>
				<td><%=u.getPassword()%></td>
				<td><%=u.getEmail()%></td>
				<td><%=u.getContact()%></td>
				<td><%=u.getAddress()%></td>
				<td><%=u.getType()%></td>
			<td><a href="Delete?userName=<%=u.getUsername()%>">Delete</a></td>
			</tr>
<%} %>
		</table>

	</form>


</body>
</html>