package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	
	@RequestMapping("/")
	public ModelAndView welcomeWithOutLogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView("Welcome");
		
		return modelandview;
	}
	
	@RequestMapping("/loginSucceed")
	public ModelAndView welcomeWithLogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView("LoginWelcome");
		
		return modelandview;
		
		
	}
	
	
}
