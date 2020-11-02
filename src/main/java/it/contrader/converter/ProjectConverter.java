package it.contrader.converter;


import it.contrader.dto.ProjectDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Project;
import it.contrader.model.User;


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
