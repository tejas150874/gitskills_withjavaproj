package tech.suj.Model;

public class Employee3 {
	 private int    empId ;
	 private String empName ;
     private String empEmailId ;
	 private String empPhoneNo ;
	 private String empGrade ;
	 
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpPhoneNo() {
		return empPhoneNo;
	}

	public void setEmpPhoneNo(String empPhoneNo) {
		this.empPhoneNo = empPhoneNo;
	}

	public String getEmpGrade() {
		return empGrade;
	}

	public void setEmpGrade(String empGrade) {
		this.empGrade = empGrade;
	}

	public Employee3() {
		
	}

	public Employee3(int empId, String empName, String empEmailId, String empPhoneNo, String empGrade) {
		
		this.empId = empId;
		this.empName = empName;
		this.empEmailId = empEmailId;
		this.empPhoneNo = empPhoneNo;
		this.empGrade = empGrade;
	}

	@Override
	public String toString() {
		return "Employee3 [empId=" + empId + ", empName=" + empName + ", empEmailId=" + empEmailId + ", empPhoneNo="
				+ empPhoneNo + ", empGrade=" + empGrade + "]";
	}
	
	
	
	
	 

}



