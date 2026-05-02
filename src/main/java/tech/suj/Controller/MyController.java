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
public class MyController 
{
	static String controlPoint = "Execution in MyController ..." ;
	
			
	@RequestMapping(value="/helloPage2", method= RequestMethod.GET)
	//@GetMapping("/helloPage2")
	public ModelAndView OpenHelloPage()
	{
		
		System.out.println("Hello World !") ;
		System.out.println("OpenHelloPage() Handler Method Executed ... Wow .. Congrtulations!!!! ");
		
		ModelAndView mav =  new ModelAndView() ;
		mav.setViewName("hello") ;
		return mav;
	}
	
}