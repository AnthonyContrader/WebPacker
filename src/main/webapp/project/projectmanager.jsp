<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ProjectDTO"
	import="it.contrader.utils.Application"
	%>
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
  <a href="homeadmin.jsp">Home</a>
  <%
  if (Application.usercheck.getUsertype().equals("ADMIN")){
  %>
  <a href="UserServlet?mode=userlist">Users</a>
  <%
	}
	%>
  <a class="active" href="ProjectServlet?mode=projectlist">Projects</a>
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
				if ( (u.getUserid() == Application.usercheck.getId() && Application.usercheck.getUsertype().equals("USER")) || Application.usercheck.getUsertype().equals("ADMIN")){
					if(request.getParameter("my_projects") == null){
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
		<%			}
					else if (u.getUserid() == Application.usercheck.getId()){
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
				}
				
			}
		%>
	
	<tr>
	<td colspan = "5" >
	<% if (Application.usercheck.getUsertype().equals("ADMIN") && request.getParameter("my_projects") == null){%>
      <button class = "bottone" onclick="window.location.href='ProjectServlet?mode=projectlist&my_projects=true'">My Projects</button>
      <% 
      }
	else{
      %>
      <button class = "bottone" onclick="window.location.href='ProjectServlet?mode=projectlist'">All Projects</button>
      <%
      } 
      %>
	</td>
	</tr>
	
	</table>

<form id="floatright" action="ProjectServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="project">Projectname</label>
    </div>
    <div class="col-75">
      <input type="text" id="project" name="projectname" placeholder="inserisci projectname">
    </div>
  </div>

      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>