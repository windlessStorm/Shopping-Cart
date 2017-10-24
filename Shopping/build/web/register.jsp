<html>
<head>
<title>Registration Form</title>
<style type="text/css">
h3{font-family: Calibri; font-size: 22pt; font-style: normal; font-weight: bold; color:SlateBlue;
text-align: center; text-decoration: underline }
table{font-family: Calibri; color:white; font-size: 11pt; font-style: normal;width: 50%;
text-align:left; background-color: SlateBlue; border-collapse: collapse; border: 2px solid navy}
table.inner{border: 0px}
</style>
</head>
 
<body>
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

<h3>Customer Registration Form</h3>
<form action="RegisterController" method="POST">
 
<table align="center" cellpadding = "10">
<tr>
<td>Username:</td>
<td><input type="text" name="username" maxlength="45"/>
(max 45 characters a-z and A-Z)
</td>
</tr>
<tr>
<td>Password</td>
<td><input type="text" name="password" maxlength="20"/>
(max 20 characters a-z and A-Z)
</td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="name" maxlength="20"/>
(max 20 characters a-z and A-Z)
</td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="email" maxlength="45" /></td>
</tr>

<tr>
<td>City</td>
<td><input type="text" name="city" maxlength="20" /></td>
</tr>
<tr>
<td>UserType</td>
<td><input type="radio" name="usertype" value="U" checked>User
    <input type="radio" name="usertype" value="A">Administrator</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</td>
</tr>
</table>
 
</form>
 
</body>
</html>