<%@page import="com.wipro.shopping.dao.LoginDao"%>
<%@page import="com.wipro.shopping.bean.UserBean"%>
<%@page import="com.wipro.shopping.dao.AddDao"%>
<%@page import="com.wipro.shopping.bean.MobileBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Items View</title>
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
AddDao mobile = new AddDao();
ArrayList<MobileBean> mobile_info = mobile.getModelInfo();
%>

<% if(mobile_info.size()>0) 
{
%>
	Mobiles currently Available:
	<br/><br/>
	
	<pre>
	Phone Model		Phone Name		Price
	-----------		----------		-----
	</pre>
	<% 
	for(MobileBean mob:mobile_info)
	{
	%>
	<pre>
	<%= mob.getModelNumber() %>			<%= mob.getModelName() %>			<%= mob.getPrice() %>
	</pre>
	<%
	}
}
else
{
%>
<h4>Sorry, we are currently OUT OF STOCK.</h4>
<%
}
%>
</body>
</html>