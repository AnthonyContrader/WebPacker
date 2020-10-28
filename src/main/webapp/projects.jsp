<%@ page import="it.contrader.dto.ProjectDTO" import="java.util.*"
  import="it.contrader.dto.UserDTO" import="java.util.*"
  	import = "it.contrader.model.User.Usertype"%>
  
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
		<% 
		 UserDTO us = (UserDTO) request.getSession().getAttribute("user"); 	
		 request.getSession().setAttribute("Errore", null);
		 if (us.getUsertype() == Usertype.ADMIN) {%>
		<a href=/user/getall>Users</a>
		<% 
		}
		%>
		<a class="active" href="/project/getall">Projects</a>
		 <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<ProjectDTO> list = (List<ProjectDTO>) request.getSession().getAttribute("list");
			UserDTO user = (UserDTO) request.getSession().getAttribute("user"); 
			String link="", buttonName="", show="display:'block';";
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
				
						if(u.getUserid() == user.getId() && user.getUsertype().toString().equals("USER") || user.getUsertype().toString().equals("ADMIN") ){
				%>
			<tr id=<%=u.getProjectid()%> style=<%=show %>>
				<td><a href="/project/read?projectid=<%=u.getProjectid()%>"> <%=u.getProjectid()%>
				</a></td>
				<td><%=u.getUserid()%></td>
				<td><%=u.getProjectname()%></td>
				<td><a href="/project/preupdate?projectid=<%=u.getProjectid()%>">Edit</a></td>
				<td><a href="/project/delete?projectid=<%=u.getProjectid()%>">Delete</a></td>

			</tr>
			<% 
			}
					
				
			}
		%>
			
	<tr>
	<td colspan = "5" >

<% 
	if(user.getUsertype().toString().equals("ADMIN")){
		show="display:'block';";
			
	}else{show="display:none;";}
	%>
	<button class = "bottone" style=<%=show %> onclick="myproject()" >My Project</button>
		</td>
	</tr>
	
		</table>


		<form id="floatright" action="/project/insert" method="post">
			<div class="row" style=<%=show %>>
				<div class="col-25">
					<label for="user">Userid</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="userid" value=<%=user.getId() %>
						placeholder="inserisci username" required>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Projectname</label>
				</div>
				<div class="col-75">
					<input type="text" id="pass" name="projectname"
						placeholder="inserisci progetto" required>
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
	<script type="text/javascript">
function myproject() {
	<%
	for (ProjectDTO u : list) {
		if(u.getUserid() != user.getId()){
		%>
		document.getElementById(<%=u.getProjectid()%>).style.display='none';
		<%
		}
	}%>
	document.getElementsByClassName("bottone")[0].innerHTML="All Projects";
	document.getElementsByClassName("bottone")[0].setAttribute( "onClick", "javascript: allproject();" );
}

function allproject() {
	window.location.href='getall';
}
</script>
</body>
</html>