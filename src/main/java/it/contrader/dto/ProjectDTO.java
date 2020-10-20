package it.contrader.dto;

public class ProjectDTO {

	private int projectid;
	private int userid;
	private String projectname;

	public ProjectDTO() {

	}

	public ProjectDTO(int userid, String projectname) {
		this.userid = userid;
		this.projectname = projectname;
	}

	public ProjectDTO(int projectid, int userid, String projectname) {
		this.projectid = projectid;
		this.userid = userid;
		this.projectname = projectname;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	@Override
	public String toString() {
		return projectid + "\t" + userid + "\t\t" + projectname;
	}
}
