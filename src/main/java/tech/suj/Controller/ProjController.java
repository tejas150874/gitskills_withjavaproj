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
public class ProjController {
	
	@RequestMapping(value="/projForm", method= RequestMethod.GET)
	//@GetMapping("/helloPage2")
	public ModelAndView ProjForm(@ModelAttribute Project project, ArrayList<Project> projectList, ArrayList<String> projectListAsStr)
	{
		
		System.out.println("Project Form") ;
		System.out.println("ProjForm() Handler Method Executed ... Wow .. Congrtulations!!!! ");
		
		ModelAndView mav =  new ModelAndView() ;
		mav.setViewName("projForm") ;
		return mav;
	}
	
	@RequestMapping(value="/projResult", method= RequestMethod.POST)
	public ModelAndView ProjResult(HttpServletRequest request, @ModelAttribute Project project, ArrayList<Project> vprojectList, ArrayList<String> vprojectListAsStr)
	//public ModelAndView ProjResult(@ModelAttribute Project project)
	{
		
		System.out.println("Project Result") ;
		System.out.println("ProjResult() Handler Method Executed ... Wow .. Congrtulations!!!! ");
		System.out.println("Project "+ project.toString()) ;
		
		ModelAndView mav =  new ModelAndView() ;
		
		ArrayList<Project> mProjectList = new ArrayList<Project>() ;
		ArrayList<String> mProjectListAsStr = new ArrayList<String>() ; 
		
		HttpSession session = request.getSession() ;
		
			mProjectList.add(project) ;
			mProjectListAsStr.add(project.toString()) ;
			System.out.println(" Project List As String  ---  "+mProjectListAsStr.get(0) ) ;
			
			mav.addObject("projectList", mProjectList) ;
			mav.addObject("projectListAsStr", mProjectListAsStr) ;
			session.setAttribute("projectList", mProjectList) ;
			session.setAttribute("projectListAsStr", mProjectListAsStr) ;
		
			
			/*
			mProjectList.add(project) ;
			mProjectListAsStr.add(project.toString()) ;
			System.out.println(" Project List As String  ---  "+mProjectListAsStr.get(0) ) ;
			
			mav.addObject("projectList", mProjectList) ;
			mav.addObject("projectListAsStr", mProjectListAsStr) ;
			session.setAttribute("projectList", mProjectList) ;
			session.setAttribute("projectListAsStr", mProjectListAsStr) ;
			*/
		mav.setViewName("projResult") ;
		return mav;
	}
	
	

}
