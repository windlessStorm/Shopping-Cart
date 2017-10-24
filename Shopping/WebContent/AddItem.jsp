<%@page import="com.wipro.shopping.dao.LoginDao"%>
<%@page import="com.wipro.shopping.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
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

<form action="AddMobileController" method="post">
ModelNumber : <input type="text" name="modelnumber" autocomplete="off"><br>
ModelName : <input type="text" name="modelname" autocomplete="off"><br>
Price : <input type="text" name="price" autocomplete="off"><br>
<input type="submit" value="Add">
</form>

<% 
String addMobile =(String)session.getAttribute("addentry");
if(addMobile != null)
{
	if(addMobile.equalsIgnoreCase("success"))
	{
%>
		<h4>Entry Successful.</h4>
<%
	}
	else
	{
%>
	Try Again.
<%
	}
}
%>
</body>
</html>