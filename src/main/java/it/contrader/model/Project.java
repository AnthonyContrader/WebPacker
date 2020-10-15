package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Project {

	/**
	 * Qui sotto definisco gli attributi di Project. 
	 */

	private String projectid;
	
	private String userid;
	
	private String projectname;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo Project
	 */
	public Project() {
		
	}

	public Project (String projectid, String userid, String projectname) {
		this.projectid = projectid;
		this.userid = userid;
		this.projectname = projectname;
	}

	public Project ( String projectid, String userid, String projectname) {
		this.username = projectid;
		this.password = userid;
		this.usertype = projectname;
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


	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getProjectid() {
		return projectid;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		"\t"  + projectid +"\t\t" +   userid + "\t\t" + projectname;
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
		User other = (Project) obj;
		
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		if (projectid == null) {
			if (other.projectid != null)
				return false;
		} else if (!projectid.equals(other.projectid))
			return false;
		if (projectname == null) {
			if (other.projectname != null)
				return false;
		} else if (!projectname.equals(other.projectname))
			return false;
		return true;
	}
}