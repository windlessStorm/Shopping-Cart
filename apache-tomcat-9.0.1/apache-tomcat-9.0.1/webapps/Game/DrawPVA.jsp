<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Draw</title>

<link rel="stylesheet" href="Master.css">
<script src="MasterWin.js">
</script>
</head>
<body bgcolor="Green">

	<!-- <div id="image"><img src="Tic.jpg"></div> -->

	<section id="main"> <canvas id="canvas" width="900"
		height="600"> </canvas> </section>

	<%
char a[][] = new char[3][3];
a = (char[][])session.getAttribute("Ar"); 
%>

	<div id="tab">
		<table cellpadding="10" align="center">
			<tr>
				<th id="player">Match</th>
				<th id="player1">Draw</th>
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

	<form action="PlayAI" method="post">

		<button type="submit" id="PlayAg">Wanna Play Again ?</button>

	</form>

</body>
</html>