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
	
	private String projectid;
	
	private String userid;
	
	private String projectname;

	
	public ProjectDTO() {
		
	}

	public ProjectDTO (String projectid, String userid, String projectname) {
		this.projectid = projectid;
		this.userid = userid;
		this.projectname = projectname;
	}

	public ProjectDTO (String projectid, String userid, String usertype) {
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


	public String getUserid() {
		return this.Userdid;
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

	@Override
	public String toString() {
	       "\t"  + projectid +"\t\t" +   userid + "\t\t" + projectname;
	}
}