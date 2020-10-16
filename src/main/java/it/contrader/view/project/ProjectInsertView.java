package it.contrader.view.project;

import it.contrader.controller.Request;
import it.contrader.main.Application;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ProjectInsertView extends AbstractView {

	private Request request;

	private int userid;
	private String projectname;
	private final String mode = "INSERT";

	public ProjectInsertView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del
	 * controller) mostra l'esito dell'operazione
	 */

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("Inserimento andato a buon fine.\n");
			System.out.println("ID progetto inserito: "+ request.get("projectid").toString());
			MainDispatcher.getInstance().callView("Project", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
		
		System.out.println("Inserisci il nome del progetto:");
		projectname = getInput();

	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("userid", Application.id_Utente);
		request.put("projectname", projectname);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Project", "doControl", request);
	}

}
