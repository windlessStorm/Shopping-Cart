<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator</title>
</head>
<body>
<%
String username = (String)session.getAttribute("username");
String password = (String)session.getAttribute("password");
session.removeAttribute("addentry");
session.removeAttribute("delete");
session.removeAttribute("modify_mobile");
%>
<% if(username==null) {
response.sendRedirect("login.jsp");
} %>
<h1>Welcome <%= username %></h1>

<a href="ChangePassword.jsp">Change Password</a><br>
<a href="AddItem.jsp">Add Mobile</a><br>
<a href="ViewItem.jsp">View Mobiles</a><br>
<a href="ModifyItem.jsp">Modify Mobile</a><br>
<a href="DeleteItem.jsp">Delete Mobile</a><br>
<a href="Logout.jsp">Logout</a>
</body>
</html>