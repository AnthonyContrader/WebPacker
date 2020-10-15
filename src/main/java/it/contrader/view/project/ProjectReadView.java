package it.contrader.view.project;

import it.contrader.controller.Request;

import it.contrader.dto.ProjectDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ProjectReadView extends AbstractView{
	private int id;
	private Request request;
	private final String mode = "READ";

	public ProjectReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			ProjectDTO project = (ProjectDTO) request.get("projectname");
			System.out.println(project);
			MainDispatcher.getInstance().callView("Project", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del progetto:");
		id = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id del progetto da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("projectid", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Project", "doControl", request);
	}

}
