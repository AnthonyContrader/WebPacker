package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.UserDataDTO;
import it.contrader.service.UserDataService;


/**
 * 
 * Questa classe estende UserDataController con tipo UserDataDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di ottenimento di un progetto??
 * 
 * @author Crapara Team
 * 
 * @param<UserDataDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/userdata")
@CrossOrigin(origins = "http://localhost:4200")
public class UserDataController extends AbstractController<UserDataDTO>{
	
/*
	@Autowired
	private ProjectService ProjectService;

	//POST Angular a UserDTO
	@PostMapping(value = "/login")
	public ProjectDTO login( @RequestBody LoginDTO loginDTO ) {
		//Metodo per trovare il progetto specifico by projectid
		return ProjectService.findById(loginDTO.getUsername(), loginDTO.getPassword());
	}
*/
}