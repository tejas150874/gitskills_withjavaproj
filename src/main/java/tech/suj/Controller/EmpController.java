package tech.suj.Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


@Controller
public class EmpController {

	@RequestMapping(value="/empForm", method= RequestMethod.GET)
	//@GetMapping("/helloPage2")
	public ModelAndView EmpForm()
	{
		
		System.out.println("Employee Form") ;
		System.out.println("EmpForm() Handler Method Executed ... Wow .. Congrtulations!!!! ");
		
		ModelAndView mav =  new ModelAndView() ;
		mav.setViewName("empForm") ;
		return mav;
	}
	
	@RequestMapping(value="/empResult", method= RequestMethod.POST)
	public ModelAndView EmpResult(HttpServletRequest request, @ModelAttribute Employee3 employee3 )
	//public ModelAndView EmpResult(HttpServletRequest request, @ModelAttribute Employee3 employee3)
	{
		
		System.out.println("Employee Result") ;
		System.out.println("EmpResult() Handler Method Executed ... Wow .. Congrtulations!!!! ");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("tech/suj/config/myds-servlet.xml");
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate" , JdbcTemplate.class) ;
		
		String query = "insert into employees (empName, empEmailId, empPhoneNo, empGrade) values (?, ?, ?, ?) " ;
		jdbcTemplate.update(query,employee3.getEmpName(),employee3.getEmpEmailId(),employee3.getEmpPhoneNo(), employee3.getEmpGrade() ) ;
		//context. //how to close context
		
		System.out.println(employee3.getEmpName());
		System.out.println(employee3.getEmpEmailId());
		System.out.println(employee3.getEmpPhoneNo());
		System.out.println(employee3.getEmpGrade());
		
		
		
		ModelAndView mav =  new ModelAndView() ;
		mav.setViewName("empResult") ;
		return mav;
	}
	
	@RequestMapping(value="/empList", method= RequestMethod.GET)
	public ModelAndView EmpList(HttpServletRequest request, @ModelAttribute Employee3 employee3 )
	{
		System.out.println("Employee List") ;
		System.out.println("EmpList() Handler Method Executed ... Wow .. Congrtulations!!!! ");
		
		ModelAndView mav =  new ModelAndView() ;
				
		ArrayList<Employee3> mEmployeeList = new ArrayList<Employee3>() ;
		ArrayList<String> mEmployeeListAsStr = new ArrayList<String>() ; 
		
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
		
		
		for(Employee3 e :mEmployeeList)
		{
			System.out.println(e.getEmpId());
			System.out.println(e.getEmpName());
			System.out.println(e.getEmpEmailId());
			System.out.println(e.getEmpPhoneNo());
			System.out.println(e.getEmpGrade());
			
			mEmployeeListAsStr.add(e.toString()) ;
			System.out.println(" Employee List As String  ---  "+e.toString() ) ;
		}
		
		mav.addObject("employeeList", mEmployeeList) ;
		mav.addObject("employeeListAsStr", mEmployeeListAsStr) ;
		
		mav.setViewName("empList") ;
		return mav;
	}

}
