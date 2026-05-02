package tech.suj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpControllerNew {
	
	@RequestMapping(value="/empForm_old", method= RequestMethod.GET)
	//@GetMapping("/helloPage2")
	public ModelAndView EmpForm()
	{
		
		System.out.println("Employee Form") ;
		System.out.println("EmpForm() Handler Method Executed ... Wow .. Congrtulations!!!! ");
		
		ModelAndView mav =  new ModelAndView() ;
		mav.setViewName("empForm") ;
	 
		return mav ;
	}

	
	
}
