package tech.suj.Model;

import tech.suj.Model.Project ;
import java.util.List ;
import java.util.ArrayList ;

public class Employee4 {
	 private int    empId2 ;
	 private String empName2 ;
     private String empEmailId2 ;
	 private String empPhoneNo2 ;
	 private String empGrade2 ;
	 private ArrayList<Project> projects ;
	 
	
	public int getEmpId2() {
		return empId2;
	}

	public void setEmpId2(int empId) {
		this.empId2 = empId;
	}

	public String getEmpName2() {
		return empName2;
	}

	public void setEmpName2(String empName) {
		this.empName2 = empName;
	}

	public String getEmpEmailId2() {
		return empEmailId2;
	}

	public void setEmpEmailId2(String empEmailId) {
		this.empEmailId2 = empEmailId;
	}

	public String getEmpPhoneNo2() {
		return empPhoneNo2;
	}

	public void setEmpPhoneNo2(String empPhoneNo) {
		this.empPhoneNo2 = empPhoneNo;
	}

	public String getEmpGrade2() {
		return empGrade2;
	}
	public void setEmpGrade2(String empGrade) {
		this.empGrade2 = empGrade;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public Project getProject(int i) {
		return this.getProjects().get(i);
	}
	
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	

	public Employee4() {
		
	}

	public Employee4(int empId2, String empName2, String empEmailId2, String empPhoneNo2, String empGrade2,
			ArrayList<Project> projects) {
		super();
		this.empId2 = empId2;
		this.empName2 = empName2;
		this.empEmailId2 = empEmailId2;
		this.empPhoneNo2 = empPhoneNo2;
		this.empGrade2 = empGrade2;
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee4 [empId2=" + empId2 + ", empName2=" + empName2 + ", empEmailId2=" + empEmailId2
				+ ", empPhoneNo2=" + empPhoneNo2 + ", empGrade2=" + empGrade2 + ", projects=" + projects + "]";
	}

	

}
