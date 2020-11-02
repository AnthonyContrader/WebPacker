package it.contrader.converter;


import org.springframework.stereotype.Component;

import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;

/**
 * Questa classe implementa i metodi di conversione dell'entità Project.
 *  
 * @author Crapara Team
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class ProjectConverter extends AbstractConverter<Project,ProjectDTO> {

	
	@Override
	public Project toEntity(ProjectDTO projectDTO) {
		Project project = null;
		if (projectDTO != null) {
			project = new Project(projectDTO.getProjectid(),projectDTO.getUserid(),projectDTO.getProjectname());			
		}
		return project;
	}

	@Override
	public ProjectDTO toDTO(Project project) {
		ProjectDTO projectDTO = null;
		if (project != null) {
			projectDTO = new ProjectDTO(project.getProjectid(),project.getUserid(),project.getProjectname());
			
		}
		return projectDTO;
	}
	
}
