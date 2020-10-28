<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.ProjectDTO"
	 import="it.contrader.dto.UserDTO" import="java.util.*"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Project Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Project</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a href=/project/getall>Users</a> <a
			class="active" href="/project/getall">Projects</a> <a
			href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	<div class="main">

		<%
			ProjectDTO u = (ProjectDTO) request.getSession().getAttribute("dto");
			UserDTO user = (UserDTO) request.getSession().getAttribute("user"); 
			String show="display:none;";
			if(user.getUsertype().toString().equals("ADMIN")){
				show="display:'block';";
				}
		%>


		<form id="floatleft" action="/project/update" method="post">
			<input type="hidden" id="projectid" name="projectid" value=<%=u.getProjectid()%> required>		
			<div class="row" style=<%=show %>>
				<div class="col-25">
					<label for="user">userid</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="userid" value=<%=u.getUserid()%> required>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="projectname">projectname</label>
				</div>
				<div class="col-75">
					<input type="text" id="projectname" name="projectname"
						value=<%=u.getProjectname()%>>
				</div>
			</div>
	<button type="submit">Edit</button>
	</form>

</div>


	
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>