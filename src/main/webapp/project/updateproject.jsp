<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProjectDTO"%>
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
  <a class="active" href="ProjectServlet?mode=projectlist">Projects</a>
  <a href="UserServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ProjectDTO u = (ProjectDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ProjectServlet?mode=update&id=<%=u.getProjectid()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="project">Project name</label>
    </div>
    <div class="col-75">
      <input type="text" id="project" name="projectname" value=<%=u.getProjectname()%>>
    </div>
  </div>
<div class="row">
    <div class="col-25">
     <label for="userid">User Id</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="password" value=<%=u.getUserid()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>