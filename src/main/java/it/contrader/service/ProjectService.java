package it.contrader.service;

import it.contrader.converter.ProjectConverter;
import it.contrader.dao.ProjectDAO;
import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;

/**
 * 
 * @author Raffaele
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class ProjectService extends AbstractService<Project, ProjectDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public ProjectService(){
		this.dao = new ProjectDAO();
		this.converter = new ProjectConverter();
	}
	

}
