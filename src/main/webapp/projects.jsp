<%@ page import="it.contrader.dto.ProjectDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Project Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a  href="/user/getall">Users</a>
		<a class="active" href="/project/getall">Projects</a>
		 <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<ProjectDTO> list = (List<ProjectDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Projectid</th>
				<th>Userid</th>
				<th>Projectname</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (ProjectDTO u : list) {
			%>
			<tr>
				<td><a href="/project/read?projectid=<%=u.getProjectid()%>"> <%=u.getProjectid()%>
				</a></td>
				<td><%=u.getUserid()%></td>
				<td><%=u.getProjectname()%></td>
				<td><a href="/project/preupdate?projectid=<%=u.getProjectid()%>">Edit</a></td>
				<td><a href="/project/delete?projectid=<%=u.getProjectid()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/project/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Userid</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="userid"
						placeholder="inserisci username">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Projectname</label>
				</div>
				<div class="col-75">
					<input type="text" id="pass" name="projectname"
						placeholder="inserisci password">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>