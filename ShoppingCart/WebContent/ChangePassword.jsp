<%@page import="com.wipro.shopping.dao.LoginDao"%>
<%@page import="com.wipro.shopping.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<%
String username = (String)session.getAttribute("username");
String password = (String)session.getAttribute("password");
UserBean user = new UserBean();
user.setUserId(username);
user.setPassword(password);
LoginDao login = new LoginDao();
boolean access = login.userAccess(user);
if(access)
{
%>
	<a href="AdminPage.jsp">Home</a>
<%
}
else
{
%>
	<a href="UserPage.jsp">Home</a>
<%
}
%>

<br/><br/><br/><br/>

<%
username = (String)session.getAttribute("username");
password = (String)session.getAttribute("password");

if(username==null) {
response.sendRedirect("index.jsp");
}
String password_status =(String)session.getAttribute("password_status"); 
if(password_status!=null)
if(password_status.equalsIgnoreCase("password_updated"))
{
%>
	<h4 align="center">Password Successfully Updated</h4>
<% 	
}
else
{
%>	
	<h4 align="center">Password Successfully Updation Failed</h4>
<% 	
} 
%>
<form action="PasswordController" method="post">
	Old Password: <input type="password" name="old_password"><br/>
	New Password: <input type="password" name="new_password"><br/>
	<input type="submit" value="Change">
</form>

</body>
</html>