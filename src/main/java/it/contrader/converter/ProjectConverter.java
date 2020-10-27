package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ProjectDTO;

import it.contrader.model.Project;

@Component
public class ProjectConverter extends AbstractConverter<Project, ProjectDTO> {

	@Override
	public Project toEntity(ProjectDTO ProjectDTO) {
		Project Project = null;
		if (ProjectDTO != null) {
			Project = new Project(ProjectDTO.getProjectid(), ProjectDTO.getUserid(), ProjectDTO.getProjectname());
		}
		return Project;
	}

	@Override
	public ProjectDTO toDTO(Project Project) {
		ProjectDTO ProjectDTO = null;
		if (Project != null) {
			ProjectDTO = new ProjectDTO(Project.getProjectid(), Project.getUserid(), Project.getProjectname());

		}
		return ProjectDTO;
	}

}