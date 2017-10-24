<%@page import="com.wipro.shopping.bean.MobileBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wipro.shopping.dao.AddDao"%>
<%@page import="com.wipro.shopping.dao.LoginDao"%>
<%@page import="com.wipro.shopping.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Item</title>
<script type="text/javascript">
	function hide()
	{
		document.getElementById('edit').style.display = "none";
	}
	function switch_mode()
	{
		document.getElementById('edit').style.display = "block";
		document.getElementById('show').style.display = "none";
	}
</script>

</head>
<body onload="hide()">
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
	
				<table cellspacing="40">
				<tr>
					<th>Phone Model</th>
					<th>Phone Name</th>
					<th>Price</th>
				</tr>
				
	
	<% 
	for(MobileBean mob:mobile_info)
	{
	%>
		<%
		String modify_mobile = (String)session.getAttribute("modify_mobile");
		if(modify_mobile!=null)
		{
			if(modify_mobile.equalsIgnoreCase( mob.getModelNumber() ))
			{
			%>
			<tr>
			<form action="ModifyMobileController" method="post">
				<input type="hidden" name="old_model_number" value="<%= mob.getModelNumber() %>">
				<td>
					<input type="text" name="new_model_number" placeholder="<%= mob.getModelNumber() %>" required>
				</td>
				<td>	
					<input type="text" name="model_name" placeholder="<%= mob.getModelName() %>" required>
				</td>
				<td>
					<input type="text" name="price" placeholder="<%= mob.getPrice() %>" required>
				</td>
				<td>
					<input type="submit" value="Save">
				</td>
			</form>
			</tr> 
			<%
			}
			else
			{
			%>
				<div id="show">	
					<tr>
						<td><%= mob.getModelNumber() %></td>
						<td><%= mob.getModelName() %></td>
						<td><%= mob.getPrice() %></td>
						<td>
							<form method="post" action="ModifyMobileController">
								<input type="hidden" name="old_model_number" value="<%= mob.getModelNumber() %>">
								<input type="submit" value="Edit">
							</form>
						</td>						
					</tr>
				</div>
			<%	
			}
		}
		else
		{
		%>
			<div id="show">	
				<tr>
					<td><%= mob.getModelNumber() %></td>
					<td><%= mob.getModelName() %></td>
					<td><%= mob.getPrice() %></td>
					<td>
						<form method="post" action="ModifyMobileController">
							<input type="hidden" name="old_model_number" value="<%= mob.getModelNumber() %>">
							<input type="submit" value="Edit">
						</form>
					</td>						
				</tr>			
			</div>
			
		<%
		}
	}
		%>
		</table>
<%
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