package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ProjectDTO;
import it.contrader.service.Service;
import it.contrader.utils.Application;
import it.contrader.service.ProjectService;

public class ProjectServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public ProjectServlet() {
		
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ProjectDTO> service = new ProjectService();
		List<ProjectDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Service<ProjectDTO> service = new ProjectService();
		String mode = request.getParameter("mode");
		ProjectDTO dto;
		int projectid;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "PROJECTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			
			break;
		
		case "READ":
			projectid = Integer.parseInt(request.getParameter("projectid"));
			dto = service.read(projectid);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/project/readproject.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/project/updateproject.jsp").forward(request, response);
			break;
		
		case "INSERT":
			String projectname = request.getParameter("projectname").toString();
			int userid = Application.usercheck.getId();
			dto = new ProjectDTO (userid, projectname);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			break;
		
		case "UPDATE":
			projectname = request.getParameter("projectname");
			userid = Integer.parseInt(request.getParameter("userid"));
			projectid = Integer.parseInt(request.getParameter("projectid"));
			System.out.println(projectname+" "+userid+" "+projectid);
			dto = new ProjectDTO(projectid, userid, projectname);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			break;
		
		case "DELETE":
			projectid = Integer.parseInt(request.getParameter("projectid"));
			ans = service.delete(projectid);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/project/projectmanager.jsp").forward(request, response);
			break;
		
			
		}
	}
	
}
