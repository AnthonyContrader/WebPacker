package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.converter.UserConverter;
import it.contrader.dao.ProjectRepository;
import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;

public class ProjectService extends AbstractService {
	@Autowired
	private ProjectConverter converter; 
	@Autowired
	private ProjectRepository repository; 

	public ProjectDTO findByProjectId( int id) {
		return converter.toDTO(repository.findByProjectId(id));
	}
}