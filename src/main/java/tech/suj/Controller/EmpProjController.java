package tech.suj.Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap ;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;

import org.springframework.web.servlet.ModelAndView; 

import org.springframework.web.bind.annotation.GetMapping ;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper ;
import java.sql.SQLException;

import tech.suj.Model.Employee3 ;
import tech.suj.Model.Employee4 ;
import tech.suj.Model.Project ;
import tech.suj.Model.Employees_Project;


@Controller
public class EmpProjController {

	@RequestMapping(value="/empProjForm", method= RequestMethod.GET)
	public ModelAndView EmpProjForm()
	{
		
		System.out.println("Employee With Project Form") ;
		System.out.println("EmpProjForm() Handler Method Executed ... Wow .. Congrtulations!!!! ");
		
		ModelAndView mav =  new ModelAndView() ;
		
		List<String> projectListAsStr = getProjDaoImpl(); //Get Projects from Db
		mav.addObject("projectListAsStr", projectListAsStr) ;
		
		
		mav.setViewName("empProjForm") ;
		return mav;
	}
	
	@RequestMapping(value="/empProjResult", method= RequestMethod.POST)
	public ModelAndView EmpProjResult(HttpServletRequest request, @ModelAttribute Employee3 employee3, 
			String[] projects , ArrayList<Project> projectList2)
	
	//public ModelAndView EmpProjResult(HttpServletRequest request, @ModelAttribute Employee3 employee3, String[] projectListAsStr
	//		, String[] projects , ArrayList<Project> projectList2)
	{
		
		System.out.println("Employee - Project Result") ;
		System.out.println("EmpProjResult() Handler Method Executed ... Wow .. Congrtulations!!!! ");
		
		
		
		System.out.println(employee3.getEmpName());
		System.out.println(employee3.getEmpEmailId());
		System.out.println(employee3.getEmpPhoneNo());
		System.out.println(employee3.getEmpGrade());
		
		System.out.println("Projects Tor Employee : ") ;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("tech/suj/config/myds-servlet.xml");
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate" , JdbcTemplate.class) ;
		
		
		
		String query = "insert into employees (empName, empEmailId, empPhoneNo, empGrade) values (?, ?, ?, ?) " ;
		jdbcTemplate.update(query,employee3.getEmpName(),employee3.getEmpEmailId(),employee3.getEmpPhoneNo(), employee3.getEmpGrade() ) ;
		
		
		String empName = employee3.getEmpName() ;
		
		Employee3 e3 = this.getEmpIdFromNameDaoImpl(empName);
		int mEmpId = e3.getEmpId() ;
		employee3.setEmpId(mEmpId) ;
		
		Project p = new Project() ;
		String[] projectListAsStr2  = {" " , " " , " " ," " ," " } ;
		
		//List<Project> projectList2 = new ArrayList<Project> () ;
		
		String tProjId = null;
		String tProjName = null ;
		
		for(int k = 0; k < projects.length ; k++)
		{
			tProjId = "p"+projects[k].substring(0,2) ;
			tProjName = projects[k] ;
			
			p.setProjId(tProjId) ;
			p.setProjName(tProjName) ;
			
			
			
			System.out.println(p.getProjId());
			System.out.println(p.getProjName());
			
			System.out.println("Updating ProjectId For Index.... "+ k);
			
			String projName = p.getProjName();
			
			Project p3 = this.getProjectIdFromNameDaoImpl(projName);
			//Project p3 = new Project();
			//p3.setProjId(tProjId) ;
			
			String projId = p3.getProjId() ;
			String mProjId = p.getProjId() ;
			
			p.setProjId(tProjId) ;
			p.setProjName(tProjName);
		
			
			System.out.println(tProjId );
			System.out.println(p.getProjName());
		
			String query2 = "insert into employees_project (empId, projId) values (?, ?) " ;
			jdbcTemplate.update(query2,mEmpId, projId ) ;
			
			projectListAsStr2[k] = p.toString() ;
			projectList2.add(p) ;
			
			System.out.println("") ;
			
			System.out.println("ProjectListAsStr2 -- K index "+ k + " value " + projectListAsStr2[k] ) ;
			
			System.out.println("ArrayList ProjectList2 -- K index "+ k + " value " + projectList2.get(k).getProjId() + " " + projectList2.get(k).getProjName()) ;
			
		}
		
		ModelAndView mav =  new ModelAndView() ;
		mav.addObject("employee3", employee3) ;
		mav.addObject("proiectListAsStr2", projectListAsStr2) ;
		mav.addObject("proiectList2", projectList2) ;
		mav.setViewName("empProjResult") ;
		return mav;
	}
	
	@RequestMapping(value="/empProjList", method= RequestMethod.GET)
	public ModelAndView EmpProjList(HttpServletRequest request, @ModelAttribute Employee3 employee3,
			ArrayList<Employee4> mEmployee4List,
			HashMap<Integer,String> aEmpProjMap)
	{
		System.out.println("Employee List") ;
		System.out.println("EmpList() Handler Method Executed ... Wow .. Congrtulations!!!! ");
		
		ModelAndView mav =  new ModelAndView() ;
				
		ArrayList<Employee3> mEmployeeList = new ArrayList<Employee3>() ;
				
		Project mProject = new Project() ;
		ArrayList mProjectList = new ArrayList<Project>() ;
		
		List<Employees_Project> mEmpProjList = new ArrayList<Employees_Project> () ;
		
		ArrayList<Employees_Project> mEmpProjList2 = new ArrayList<Employees_Project> () ;
		
		Employees_Project mEmp_Proj = new Employees_Project() ;
		
		mEmployee4List = new ArrayList<Employee4>() ;
				
		ApplicationContext context = new ClassPathXmlApplicationContext("tech/suj/config/myds-servlet.xml");
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate" , JdbcTemplate.class) ;
				
		String squery = "select * from employees" ;
		List<Employee3> employees = null ;
		employees = jdbcTemplate.query(squery, new RowMapper()
		{
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				Employee3 employee = new Employee3();
				employee.setEmpId(rs.getInt(1)) ;
				employee.setEmpName(rs.getString(2)) ;
				employee.setEmpEmailId(rs.getString(3)) ;
				employee.setEmpPhoneNo(rs.getString(4)) ;
				employee.setEmpGrade(rs.getString(5)) ;
				
				return employee ;
			}
		}   ) ;
		 
		mEmployeeList = (ArrayList<Employee3>) employees ;
		
		int fEmpId = 0 ;
		aEmpProjMap = new HashMap <>() ;
		int r = 1 ;
		for(Employee3 e :mEmployeeList)
		{
			fEmpId = e.getEmpId() ;
			System.out.println(e.getEmpId());
			System.out.println(e.getEmpName());
			System.out.println(e.getEmpEmailId());
			System.out.println(e.getEmpPhoneNo());
			System.out.println(e.getEmpGrade());
			
			Employee4 mEmployee4 = new Employee4() ;
			mEmployee4.setEmpId2(e.getEmpId()) ;
			mEmployee4.setEmpName2(e.getEmpName()) ;
			mEmployee4.setEmpEmailId2(e.getEmpEmailId()) ;
			mEmployee4.setEmpPhoneNo2(e.getEmpPhoneNo()) ;
			mEmployee4.setEmpGrade2(e.getEmpGrade()) ;
			
			squery = "select * from employees_project where empId=? " ;
			
			//List<Employee3> employees = null ;
			mEmpProjList = jdbcTemplate.query(squery, new RowMapper()
			{
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
				{
					Employees_Project mEmp_Proj = new Employees_Project() ;
					mEmp_Proj.setEmpId(rs.getInt(1)) ;
					mEmp_Proj.setProjId(rs.getString(2)) ;
					
					return mEmp_Proj ;
				}
			},fEmpId ) ;
			
			//return mEmp_Proj ;
			mEmpProjList2 = (ArrayList<Employees_Project>) mEmpProjList ;
			
			System.out.println("Employee "+ e.getEmpId() );
			
			for(int k=0; k< mEmpProjList2.size(); k++) 
			{	
				System.out.println("mEmpProjList2 "+ mEmpProjList2.get(k).getEmpId() + " " + mEmpProjList2.get(k).getProjId() ) ;
				mProject = (Project) this.getProjectFromIdDaoImpl(mEmpProjList2.get(k).getProjId()) ;
				
				System.out.println("Project	"+ mProject.getProjId() + " " + mProject.getProjName() );
				
				mProjectList.add(mProject) ;
				
				aEmpProjMap.put(r, " "+  e.getEmpName() + " - " + mEmpProjList2.get(k).getProjId()+ " " + 
						mProject.getProjName() ) ;
				r++ ;
				
			}
			mEmployee4.setProjects(mProjectList) ;
			
			
			mEmployee4List.add(mEmployee4) ;
			
		}
		
		mav.addObject("mEmployee4List", mEmployee4List) ;
		//mav.addObject("employeeListAsStr", mEmployeeListAsStr) ;
		
		mav.addObject("aEmpProjMap", aEmpProjMap) ;
		 
		mav.setViewName("empProjList") ;
		
		return mav;
	}
	
	public List<String> getProjDaoImpl()
	{
			// get projects from Db
		
		List<Project> projectFromDb = new ArrayList<Project>();
		
		ArrayList<Project> mProjectList = new ArrayList<Project>() ;
		List<String> mProjectListAsStr = new ArrayList<String>() ; 
		
		ApplicationContext context = new ClassPathXmlApplicationContext("tech/suj/config/myds-servlet.xml");
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate" , JdbcTemplate.class) ;
				
		String squery2 = "select * from project" ;
		
		projectFromDb = jdbcTemplate.query(squery2, new RowMapper()
		{
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				Project proj = new Project();
				
				proj.setProjId(rs.getString(1)) ;
				proj.setProjName(rs.getString(2)) ;
				
				
				return proj ;
			}
		}   ) ;
		 
		mProjectList = (ArrayList<Project>) projectFromDb ; // Is this required? - Try to remove and test
		
		
		for(Project p :mProjectList)
		{
			System.out.println(p.getProjId());
			System.out.println(p.getProjName());
			
			
			mProjectListAsStr.add(p.toString()) ;
			System.out.println(" Project List As String  ---  "+p.toString() ) ;
		}
		
		return mProjectListAsStr ;
	}
	
	public Project getProjectIdFromNameDaoImpl(String projectName) {
		// Get ProjectId from Project Name from Db
		ApplicationContext context = new ClassPathXmlApplicationContext("tech/suj/config/myds-servlet.xml");
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate" , JdbcTemplate.class) ;
				
		String squery2 = "select * from project where projName =  ? " ;
		
		Project p2 = new Project() ;
		
		Object o2  = jdbcTemplate.queryForObject(squery2, new RowMapper()
		{
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				Project proj = new Project();
				
				proj.setProjId(rs.getString(1)) ;
				proj.setProjName(rs.getString(2)) ;
				
			
				return proj ;
			}
		}  ,projectName  ) ;
		
		p2 = (Project) o2 ;
		return p2 ;
	}
	
	public Project getProjectFromIdDaoImpl(String projectId)
	{
		// Get Project from Project Id from Db
		ApplicationContext context = new ClassPathXmlApplicationContext("tech/suj/config/myds-servlet.xml");
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate" , JdbcTemplate.class) ;
				
		String squery2 = "select * from project where projId =  ? " ;
		
		Project p2 = new Project() ;
		
		Object o2  = jdbcTemplate.queryForObject(squery2, new RowMapper()
		{
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				Project proj = new Project();
				
				proj.setProjId(rs.getString(1)) ;
				proj.setProjName(rs.getString(2)) ;
				
			
				return proj ;
			}
		}  ,projectId  ) ;
		
		p2 = (Project) o2 ;
		return p2 ;
		
	}
	
	public Employee3 getEmpIdFromNameDaoImpl(String empName) 
	{
		
		// Get EmpId from Employee Name from Db
		ApplicationContext context = new ClassPathXmlApplicationContext("tech/suj/config/myds-servlet.xml");
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate" , JdbcTemplate.class) ;
				
		String squery2 = "select * from employees where empName =  ? " ;
		
		Employee3 e2 = new Employee3() ;
		
		Object o2  = jdbcTemplate.queryForObject(squery2, new RowMapper()
		{
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				Employee3 emp = new Employee3();
				
				emp.setEmpId(rs.getInt(1)) ;
				emp.setEmpName(rs.getString(2)) ;
				emp.setEmpEmailId(rs.getString(3)) ;
				emp.setEmpPhoneNo(rs.getString(4)) ;
				emp.setEmpGrade(rs.getString(5)) ;
				
			
				return emp ;
			}
		}  ,empName  ) ;
		
		e2 = (Employee3) o2 ;
		System.out.println(" EmpId is "+ e2.getEmpId()) ;
		return e2 ;
	}

}
