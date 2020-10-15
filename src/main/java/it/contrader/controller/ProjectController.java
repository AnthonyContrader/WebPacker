package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ProjectDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ProjectService;


public class ProjectController implements Controller{
	/**
	 * definisce il pacchetto di vista user.
	 */
	private static String sub_package = "project.";
	
	private ProjectService projectService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public ProjectController() {
		this.projectService = new ProjectService();
	}
	
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		int projectId;
		int uderId;
		String projectName;
		
		switch(mode) {
		// Arriva qui dalla ProjectReadView. Invoca il Service con il parametro id e invia alla ProjectReadView un project da mostrare 
		case "READ":
			uderId = Integer.parseInt(request.get("projectId").toString());
			ProjectDTO projectDTO = projectService.read(projectId);
			request.put("projectname", projectDTO);
			MainDispatcher.getInstance().callView(sub_package + "ProjectRead", request);
			break;
			
			// Arriva qui dalla ProjectInsertView. Estrae i parametri da inserire e chiama il service per inserire un project con questi parametri
		case "INSERT":
			projectName = request.get("projectname").toString();
			uderId = Integer.parseInt(request.get("uderid").toString());
			projectId = Integer.parseInt(request.get("projectid").toString());
				
			//costruisce l'oggetto project da inserire
			ProjectDTO projectToInsert = new ProjectDTO(projectId, userId, projectName);
			//invoca il service
			ProjectService.insert(projectToInsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "ProjectInsert", request);
			break;
			
		// Arriva qui dalla ProjectDeleteView. Estrae l'id del progetto da cancellare e lo passa al Service
		case "DELETE":
			projectId = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			ProjectService.delete(projectId);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ProjectDelete", request);
			break;
			
		case "PROJECTLIST":
			List<ProjectDTO> projectsDTO = projectService.getAll();
			//Impacchetta la request con la lista dei project
			request.put("projects", projectsDTO);
			MainDispatcher.getInstance().callView("Project", request);
			break;
			//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
			//con REQUEST NULL (vedi una View specifica)
			case "GETCHOICE":
						
						//toUpperCase() mette in maiuscolo la scelta
				switch (choice.toUpperCase()) {
				
				case "L":
					MainDispatcher.getInstance().callView(sub_package + "ProjectRead", null);
					break;
					
				case "I":
					MainDispatcher.getInstance().callView(sub_package + "ProjectInsert", null);
					break;
					
					
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "ProjectDelete", null);
					break;
					
				case "E":
					MainDispatcher.getInstance().callView("Login", null);
					break;

				case "B":
					MainDispatcher.getInstance().callView("HomeUser", null);
					break;
					
				default:
					MainDispatcher.getInstance().callView("Login", null);
				}
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
