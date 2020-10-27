package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ProjectDTO;
import it.contrader.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "projects";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("projectid") Long projectid) {
		service.delete(projectid);
		setAll(request);
		return "projects";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("projectid") Long projectid) {
		request.getSession().setAttribute("dto", service.read(projectid));
		return "updateproject";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("projectid") Long projectid, @RequestParam("userid") Long userid,
			@RequestParam("projectname") String projectname) {

		ProjectDTO dto = new ProjectDTO();
		dto.setProjectid(projectid);
		dto.setProjectname(projectname);
		dto.setUserid(userid);
		service.update(dto);
		setAll(request);
		return "projects";

	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("projectid") Long projectid,
			@RequestParam("userid") Long userid, @RequestParam("projectname") String projectname) {
		ProjectDTO dto = new ProjectDTO();
		dto.setProjectname(projectname);
		dto.setUserid(userid);
		dto.setProjectid(projectid);
		service.insert(dto);
		setAll(request);
		return "projects";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("projectid") Long projectid) {
		request.getSession().setAttribute("dto", service.read(projectid));
		return "readproject";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}

}
