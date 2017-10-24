<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body bgcolor="green">

<h1 align="center">Best Shopping Website</h1>
<h3>Login</h3>

<% 
String user_verify = (String)session.getAttribute("authentication"); 
if(user_verify != null)
{
%>
<h4 align="center">User Authentication Failed</h4>
<%
}
%>
<form action="LoginController" method="post">
	Username: <input type="text" name="username" autocomplete="off"><br>
	Password: <input type="password" name="password"><br>
	<input type="submit" value="Login">
</form>

<br><br>

<h3>Register</h3>
<% 
String register = (String)session.getAttribute("registration"); 
if(register != null)
{
	if(register.equalsIgnoreCase("success"))
	{
	%>
	<h4 align="center">Registration Successful</h4>
	<%
	}
	else
	{
	%>
	<h4 align="center">Registration Failed</h4>
	<%
	}
	
}
%>
<form action="RegisterController" method="post">
	Username: <input type="text" name="username" autocomplete="off" maxlength="45" required><br>
	Password: <input type="password" name="password" maxlength="20"><br>
	Name: <input type="text" name="name" autocomplete="off" maxlength="20"><br>
	Email: <input type="text" name="email" autocomplete="off" maxlength="45"><br>
	City: <input type="text" name="city" autocomplete="off" maxlength="20"><br>
	UserType: <input type="radio" name="usertype" value="U" checked>User <input type="radio" name="usertype" value="A">Administrator<br>
	<input type="submit" value="Register">
</form>

</body>
</html>