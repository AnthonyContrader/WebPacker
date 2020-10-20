<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ProjectDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Project Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="ProjectServlet?mode=projectlist">Project</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ProjectDTO> list = (List<ProjectDTO>) request.getAttribute("list");
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
			<td><a href=ProjectServlet?mode=read&projectid=<%=u.getProjectid()%>>
					<%=u.getProjectid()%>
			</a></td>
			<td><%=u.getUserid()%></td>
			<td><%=u.getProjectname()%></td>
			<td><a href=ProjectServlet?mode=read&update=true&projectid=<%=u.getProjectid()%>>Edit</a>
			</td>
			<td><a href=ProjectServlet?mode=delete&projectid=<%=u.getProjectid()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ProjectServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="project">Projectid</label>
    </div>
    <div class="col-75">
      <input type="text" id="project" name="projectid" placeholder="inserisci projectid">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="user_id">Userid</label>
    </div>
    <div class="col-75">
      <input type="text" id="user_id" name="userid" placeholder="inserisci userid"> 
    </div>
  </div>
  
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>