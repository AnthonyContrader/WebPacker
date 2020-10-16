package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	Request request;

	@Override
	public void showResults(Request request) {
		if(request != null)
			System.out.println("\n Benvenuto " + request.get("username").toString() + "! Siamo in work in progress, ma puoi già fare cose!\n");
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("Seleziona cosa vuoi fare");
		System.out.println("\n [A]ggiungi progetto [E]sci");
		choice = this.getInput().toUpperCase();

	}

	@Override
	public void submit() {
		
		request = new Request();
		switch (choice) {
		case "A":
        	this.request.put("mode", "PROJECTLIST");
        	MainDispatcher.getInstance().callAction("Project", "doControl", request);
        	break;
		case "E":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
