<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn</title>
</head>
<body>
	<form action="LogIn" method="get">
		<table>
			<tr>
				<td colspan="2">LogIn Form</td>
			</tr>
			<tr>
				<td>UserName</td>
				<td>:</td>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="text" name="password" id="password"></td>
			</tr>
			
			<tr>
			<td colspan="2" align="center"><input type="submit" name="buttonaction"  value="Login">&nbsp;&nbsp;
			<input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form>


</body>
</html>