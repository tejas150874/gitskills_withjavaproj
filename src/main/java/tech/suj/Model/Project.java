package tech.suj.Model;

public class Project {
	private String projId ;
	private String projName ;
	
	public String getProjId() {
		return projId;
	}
	
	
	
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}

	@Override
	public String toString() {
		//return "Project [projId=" + projId + ", Project Name=" + projName + "]";
		return projId + "," + projName + "---";
	}
}
