package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Project {

	/**
	 * Qui sotto definisco gli attributi di Project. 
	 */

	private int projectid;
	
	private int userid;
	
	private String projectname;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo Project
	 */
	public Project() {
		
	}

	public Project (int userid, String projectname) {
		this.userid = userid;
		this.projectname = projectname;
	}
	
	public Project (int projectid, int userid, String projectname) {
		this.projectid = projectid;
		this.userid = userid;
		this.projectname = projectname;
	}
	
	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di project
	 */

	public String getProjectname() {
		return this.projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}


	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public int getProjectid() {
		return projectid;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return projectid + "\t\t" +   userid + "\t\t" + projectname;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		
		if (userid != other.userid) {
			return false;
		}
		if (projectid != other.projectid)
			return false;
		if (projectname == null) {
			if (other.projectname != null)
				return false;
		} else if (!projectname.equals(other.projectname))
			return false;
		return true;
	}
}