package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ProjectRepository;
import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;

/**
 * Estende AbstractService con parametri Project e ProjectDTO. 
 * Implementa il metodo di ricerca ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class ProjectService extends AbstractService<Project,ProjectDTO> {
	
	//ALL crud methods in AbstractService
	

	public ProjectDTO findByProjectId(Long id) {
		return converter.toDTO(((ProjectRepository)repository).findByProjectid(id));
	}

}
