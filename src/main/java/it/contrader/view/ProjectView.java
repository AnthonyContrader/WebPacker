package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ProjectDTO;
import it.contrader.main.MainDispatcher;

public class ProjectView extends AbstractView{

	private Request request;
	private String choice;

	public ProjectView() {
		
	}

	/**
	 * Mostra la lista Progetti
	 */
	@Override
	public void showResults(Request request) {
		
		if (request != null) {
			System.out.println("\n------------------- Gestione progetti ----------------\n");
			System.out.println("ID_Progetto\\ID_Utente\\ID_NomeProgetto");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ProjectDTO> project = (List<ProjectDTO>) request.get("project");
			for (ProjectDTO u: project)
				System.out.println(u);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi ProjectController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda al ProjectController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Project", "doControl", this.request);
	}

}
