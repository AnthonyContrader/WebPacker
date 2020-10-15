package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import it.contrader.dto.UserDTO;
import it.contrader.model.User;


public class ProjectConverter   {
	
	/**
	 * Crea un oggetto di tipo ProjectDTO e lo riempie con i campi del parametro user di tipo Project.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public ProjectDTO toDTO(Project project) {
		ProjectDTO projectDTO = new ProjectDTO(project.getProjectId(), project.getUserId(), project.getProjectName());
=======
import it.contrader.dto.ProjectDTO;
import it.contrader.model.Project;

/**
 * 
 * @author Raffaele
 *
 */
public class ProjectConverter   {
	
	/**
	 * Crea un oggetto di tipo ProjectDTO e lo riempie con i campi del parametro project di tipo Project.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public ProjectDTO toDTO(Project project) {
		ProjectDTO projectDTO = new ProjectDTO(project.getProjectid(), project.getUserid(),project.getProjectname());
>>>>>>> bdc958bcaa7c914cf869fd5ec1c7842f7e00bb39
		return projectDTO;
	}

	/**
<<<<<<< HEAD
	 * Crea un oggetto di tipo Project e lo riempie con i campi del parametro user di tipo ProjectDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Project toEntity(ProjectDTO projectDTO) {
		Project projectDTO = new User(projectDTO.getProjectId(), projectDTO.getUserId(), projectDTO.getProjectName());
		return projectDTO;
=======
	 * Crea un oggetto di tipo Project e lo riempie con i campi del parametro project di tipo ProjectDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Project toEntity(ProjectDTO projectDTO) {
		Project project = new Project(project.getProjectid(), project.getUserid(),project.getProjectname());
		return project;
>>>>>>> bdc958bcaa7c914cf869fd5ec1c7842f7e00bb39
	}
	
	/**
	 * Metodo per convertire le liste di Project.
	 */
	public List<ProjectDTO> toDTOList(List<Project> projectList) {
		//Crea una lista vuota.
		List<ProjectDTO> projectDTOList = new ArrayList<ProjectDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Project project : projectList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			projectDTOList.add(toDTO(project));
		}
		return projectDTOList;
	}

	
	
<<<<<<< HEAD
}
=======
}
>>>>>>> bdc958bcaa7c914cf869fd5ec1c7842f7e00bb39
