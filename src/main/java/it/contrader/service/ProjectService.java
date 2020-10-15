package it.contrader.service;

import java.util.List;


import it.contrader.converter.ProjectConverter;
import it.contrader.dao.ProjectDAO;
import it.contrader.dto.ProjectDTO;

/**
 * 
 * @author Raffaele
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class ProjectService {
	
	private ProjectDAO projectDAO;
	private ProjectConverter projectConverter;
	
	//Istanzio DAO  e Converter specifici.
	public ProjectService(){
		this.projectDAO = new ProjectDAO();
		this.projectConverter = new ProjectConverter();
	}
	

	public List<ProjectDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return projectConverter.toDTOList(projectDAO.getAll());
	}


	public ProjectDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return projectConverter.toDTO(projectDAO.read(id));
	}


	public boolean insert(ProjectDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return projectDAO.insert(projectConverter.toEntity(dto));
	}



	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return projectDAO.delete(id);
	}
	

}
