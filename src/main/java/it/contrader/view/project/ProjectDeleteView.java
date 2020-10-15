package it.contrader.view.project;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ProjectDeleteView extends AbstractView {
	private Request request;
    private int projectid;
	private final String mode = "DELETE";

	public ProjectDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Project", null);
		}
	}

	/**
	 * Chiede all'utente di inserire il projectid dell'utente da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci Id del progetto:");
			projectid = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con il projectid dell'utente da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("projectid", projectid);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Project", "doControl", request);
	}


}