<!DOCTYPE html>
<%@page import="com.dto.User"%>
<%@page import="java.lang.*" %>
<%@page import="java.util.*" %>

<%
User user =new User();

if (session.getAttribute("user")!=null) {
	user=(User) session.getAttribute("user");
	
	System.out.println("user detail :" + user.toString());
} else
{
	user =new User("","",new Date(),"","","","","","","","");
	System.out.println("empty");
}
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<form action="SignUp" method="get">
		<table>
			<tr>
				<td colspan="2">Register Form</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>:</td>
				<td><input type="text" name="name" id="name" value=<%=user.getName()%>></td>
			</tr>
			<tr>
				<td>Age</td>
				<td>:</td>
				<td><input type="number" name="age" id="age" value=<%=user.getAge()%>></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td>:</td>
				<td><input type="date" name="dob" id="dob" value=<%=user.getDob()%>></td>
			</tr>
			<tr>
				<td>Language Known</td>
				<td>:</td>
				<td><input type="checkbox" name="lang" id="lang" value="Tamil"
				<%if(user.getLang()!=null && user.getLang().contains("Tamil")){ %>
					checked <%}%>>Tamil
					<input	type="checkbox" name="lang" id="lang" value="English"
					<%if(user.getLang()!=null && user.getLang().contains("English")){ %>
					checked<%}%> >English
					<input type="checkbox" name="lang" id="lang" value="Hindi"
					<%if(user.getLang()!=null && user.getLang().contains("Hindi")){ %>
					
					checked<%}%> >Hindi</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>:</td>
				<td><input type="radio" name="gender" id="gender" value="Male"
				<%if(user.getGender()!=null && user.getGender().equalsIgnoreCase("Male")){ %>
					checked <%}%> >Male <input
					type="radio" name="gender" id="gender" value="Female"
					<%if(user.getGender()!=null && user.getGender().equalsIgnoreCase("Female")){ %>
					checked <%}%>
					>Female</td>
			</tr>
			<tr>
				<td>UserName</td>
				<td>:</td>
				<td><input type="text" name="username" id="username"
					value=<%=user.getUsername() %>></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="text" name="password" id="password"
					value=<%=user.getPassword()%> ></td>
			</tr>
			<tr>
				<td>Email</td>
				<td>:</td>
				<td><input type="text" name="email" id="email"
					value=<%=user.getEmail() %> ></td>
			</tr>
			<tr>
				<td>contact</td>
				<td>:</td>
				<td><input type="number" name="contact" id="contact"
					value=<%=user.getContact() %>></td>
			</tr>
			<tr>
				<td>Address</td>
				<td>:</td>
				<td><textarea name="address" id="address"
						><%=user.getAddress() %></textarea></td>
			</tr>
			<tr>
				<td>Type</td>
				<td>:</td>
				<td><select id="type" name="type" >
						<option value="User"
							<%if(user.getType()!=null && user.getType().equalsIgnoreCase("User"))
						{%>
							selected <%}%> >User</option>
						<option value="Admin"
							<%if(user.getType()!=null && user.getType().equalsIgnoreCase("Admin"))
						{%>
							selected <%}%> >Admin</option>
				</select></td>
			</tr>
		
			<tr>
			<td colspan="2" align="center"><input type="submit" name="buttonaction"  value="Register">&nbsp;&nbsp;
			<input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form>
</body>
</html>