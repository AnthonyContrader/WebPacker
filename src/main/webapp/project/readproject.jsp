<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProjectDTO"
    import="it.contrader.utils.Application"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Project</title>
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


<table>
	<tr> 
		<th>Project ID</th>
		<th>Project Name</th>
		<th>User ID</th>
	</tr>
	<tr>
		<td><%=u.getProjectid()%></td>
		<td> <%=u.getProjectname()%></td>
		<td> <%=u.getUserid()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>