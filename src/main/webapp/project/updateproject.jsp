<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProjectDTO"
    import="it.contrader.utils.Application"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Project</title>
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
<br>
<div class="main">

<%ProjectDTO u = (ProjectDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ProjectServlet?mode=update&projectid=<%=u.getProjectid()%>&userid=<%=u.getUserid()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="project">Project name</label>
    </div>
    <div class="col-75">
      <input type="text" id="project" name="projectname" value=<%=u.getProjectname()%>>
    </div>
  </div>

      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>