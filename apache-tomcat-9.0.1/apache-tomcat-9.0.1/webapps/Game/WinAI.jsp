<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Winner</title>

<link rel="stylesheet" href="Master.css">
<script src="MasterWin.js">
</script>
</head>

<body bgcolor="Green">

	<section id="main"> <canvas id="canvas" width="900"
		height="600"> Get Better ! </canvas> </section>
	<%
char a[][] = new char[3][3];
a = (char[][])session.getAttribute("Ar");
int l = (int)session.getAttribute("line");
switch(l)
{
	case 3 :%>
	<script type="text/javascript">
			drawShape(3);
		</script>
	<% break;
	case 4 :%>
	<script type="text/javascript">
			drawShape(4);
		</script>
	<% break;
	case 5 :%>
	<script type="text/javascript">
			drawShape(5);
		</script>
	<% break;
	case 6 :%>
	<script type="text/javascript">
			drawShape(6);
		</script>
	<% break;
	case 7 :%>
	<script type="text/javascript">
		drawShape(7);
	</script>
	<% break;
	case 8 :%>
	<script type="text/javascript">
		drawShape(8);
	</script>
	<% break;
	case 9 :%>
	<script type="text/javascript">
		drawShape(9);
	</script>
	<% break;
	case 10 :%>
	<script type="text/javascript">
		drawShape(10);
	</script>
	<% break;
}%>

	<div id="tab">
		<table cellpadding="10" align="center">
			<tr>
				<th id="player">Well Done..</th>
				<th id="player1">
					<% String s=(String)session.getAttribute("AI");%> <%=s%>
				</th>
			</tr>
			<tr>
				<td>
					<button>
						<%if(a[0][0]=='X')
	{%>
						<script type="text/javascript">
			drawCross(1);
		</script>
						<%}if(a[0][0]=='0'){%>
						<script type="text/javascript">
		drawCircle(1);
	</script>
						<%} %>
					</button>
				</td>
				<td>
					<button>
						<%if(a[0][1]=='X')
	{%>
						<script type="text/javascript">
			drawCross(2);
		</script>
						<%}if(a[0][1]=='0'){%>
						<script type="text/javascript">
		drawCircle(2);
	</script>
						<%}%>
					</button>
				</td>
				<td>
					<button>
						<%if(a[0][2]=='X')
	{%>
						<script type="text/javascript">
			drawCross(3);
		</script>
						<%}if(a[0][2]=='0'){%>
						<script type="text/javascript">
		drawCircle(3);
	</script>
						<%}%>
					</button>
				</td>
			</tr>
			<tr>
				<td>
					<button>
						<%if(a[1][0]=='X')
	{%>
						<script type="text/javascript">
			drawCross(4);
		</script>
						<%}if(a[1][0]=='0'){%>
						<script type="text/javascript">
		drawCircle(4);
	</script>
						<%}%>
					</button>
				</td>
				<td>
					<button>
						<%if(a[1][1]=='X')
	{%>
						<script type="text/javascript">
			drawCross(5);
		</script>
						<%}if(a[1][1]=='0'){%>
						<script type="text/javascript">
		drawCircle(5);
	</script>
						<%}%>
					</button>
				</td>
				<td>
					<button>
						<%if(a[1][2]=='X')
	{%>
						<script type="text/javascript">
			drawCross(6);
		</script>
						<%}if(a[1][2]=='0'){%>
						<script type="text/javascript">
		drawCircle(6);
	</script>
						<%}%>
					</button>
				</td>
			</tr>
			<tr>
				<td>
					<button>
						<%if(a[2][0]=='X')
	{%>
						<script type="text/javascript">
			drawCross(7);
		</script>
						<%}if(a[2][0]=='0'){%>
						<script type="text/javascript">
		drawCircle(7);
	</script>
						<%}%>
					</button>
				</td>
				<td>
					<button>
						<%if(a[2][1]=='X')
	{%>
						<script type="text/javascript">
			drawCross(8);
		</script>
						<%}if(a[2][1]=='0'){%>
						<script type="text/javascript">
		drawCircle(8);
	</script>
						<%}%>
					</button>
				</td>
				<td>
					<button>
						<%if(a[2][2]=='X')
	{%>
						<script type="text/javascript">
			drawCross(9);
		</script>
						<%}if(a[2][2]=='0'){%>
						<script type="text/javascript">
		drawCircle(9);
	</script>
						<%}%>
					</button>
				</td>
			</tr>
		</table>
	</div>

	<h2 align="center">Wanna Play Again ?</h2>
	<br>
	<br>

	<form action="PlayAI" method="post">

		<button type="submit" id="PlayAg">Sure !</button>

	</form>

</body>
</html>