package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.ProjectDTO;
import it.contrader.service.ProjectService;


/**
 * 
 * Questa classe estende AbstractController con tipo ProjectDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di ottenimento di un progetto??
 * 
 * @author Stefano Marcomini
 * 
 * @param<ProjectDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController extends AbstractController<ProjectDTO>{
	
	@Autowired
	private ProjectService ProjectService;

/*
	//POST Angular a UserDTO
	@PostMapping(value = "/login")
	public ProjectDTO login( @RequestBody LoginDTO loginDTO ) {
		//Metodo per trovare il progetto specifico by projectid
		return ProjectService.findById(loginDTO.getUsername(), loginDTO.getPassword());
	}
	*/
}