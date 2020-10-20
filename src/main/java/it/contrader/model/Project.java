package it.contrader.model;

public class Project {

	private int projectid;
	private int userid;
	private String projectname;

	public Project() {

	}

	public Project(int userid, String projectname) {
		this.userid = userid;
		this.projectname = projectname;
	}

	public Project(int projectid, int userid, String projectname) {
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

	// Metodo per il confronto degli oggetti
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
