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
	
	@RequestMapping("/SearchPage.html")
	public ModelAndView searchPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView("SearchPage");
		
		return modelandview;
		
		
	}
	
	@RequestMapping("/LoginPanel")
	public ModelAndView loginPane() {
		ModelAndView modelandview = new ModelAndView("LoginPanel");
		
		return modelandview;
	}
	
	
}
