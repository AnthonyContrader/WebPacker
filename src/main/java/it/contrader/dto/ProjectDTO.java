package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class ProjectDTO {
	
	private int projectid;
	
	private int userid;
	
	private String projectname;

	
	public ProjectDTO() {
		
	}

	public ProjectDTO (int userid, String projectname) {
		this.userid = userid;
		this.projectname = projectname;
	}

	public ProjectDTO (int projectid, int userid, String projectname) {
		this.projectid = projectid;
		this.userid = userid;
		this.projectname = projectname;
	}

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

	@Override
	public String toString() {
	       return "\t"  + projectid +"\t\t" +   userid + "\t\t" + projectname;
	}
}