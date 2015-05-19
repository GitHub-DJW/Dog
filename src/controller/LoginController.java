package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HibernateUtil;
import model.Staff;
import model.SystemManger;
import model.User;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/login.html")
	public ModelAndView login(){
		ModelAndView modelandview = new ModelAndView("login");
		
		return modelandview;
	}
	
	
	@RequestMapping("/askforlogin.html")
	public ModelAndView askForLogin(){
		ModelAndView modelandview = new ModelAndView("askforlogin");
		
		return modelandview;
	}
	
	
	
	@RequestMapping("/loginDeal")
	public ModelAndView loginDeal(HttpServletRequest request,
			HttpServletResponse response, HttpSession httpsession) {	
		try {
		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");	
	    
		ModelAndView modelandview = new ModelAndView();
		String errorMessage ;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    org.hibernate.Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class); 
		criteria.add(Restrictions.eq("userName", loginName));
		
		if(criteria.list().isEmpty()) {
			errorMessage = new String("UserName not find!");
			modelandview.addObject("errorMessage",errorMessage);
			modelandview.setViewName("login"); 
			return modelandview;
		}	
		criteria.add(Restrictions.eq("password", loginPassword));
		
		if(criteria.list().isEmpty()) {
			errorMessage = new String("Password isn't correct!");
			modelandview.addObject("errorMessage",errorMessage);
			modelandview.setViewName("login");
			return modelandview;
		}
	
		User user = (User) criteria.list().get(0); 
				
		session.close();    
		System.out.println(user.getUserName() + " login in");
		
		httpsession.setAttribute("loginName", loginName);
		httpsession.setAttribute("loginNo", user.getUserNo());
		modelandview.setViewName("loginSucceed"); 
		return modelandview;
		}
		catch(Exception e) {
			e.printStackTrace();
			String errorMessage = new String("UnKnow Error ! /n"
					+ "Please find the SystemManger");
			ModelAndView modelandview = new ModelAndView("login");
			modelandview.addObject("errorMessage", errorMessage);
			return modelandview;
		}
		
		
	}
	
	@RequestMapping("/loginStaff.html")
	public ModelAndView loginStaff(){
		ModelAndView modelandview = new ModelAndView("loginStaff");
		
		return modelandview;
	}
	
	@RequestMapping("/loginStaffDeal")
	public ModelAndView loginStaffDeal(HttpServletRequest request,
			HttpServletResponse response, HttpSession httpsession) {
	    try {
	
		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");
		String loginType = request.getParameter("loginType");
		
		ModelAndView modelandview = new ModelAndView();
		String errorMessage;
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		Criteria criteria;
		
		
		if(loginType.equals(new String("libraryStaff"))) {
			criteria = session.createCriteria(Staff.class);
			criteria.add(Restrictions.eq("staffName", loginName));
			
			if(criteria.list().isEmpty()) {
				errorMessage = new String("StaffName not find!");
				modelandview.addObject("errorMessage",errorMessage);
				modelandview.setViewName("loginStaff");
				return modelandview;
			}	 
			
			criteria.add(Restrictions.eq("password", loginPassword));
			
			if(criteria.list().isEmpty()) {
				errorMessage = new String("Password isn't correct!");
				modelandview.addObject("errorMessage",errorMessage);
				modelandview.setViewName("loginStaff");
				return modelandview;
			}
			

			Staff staff = (Staff) criteria.list().get(0);
		    System.out.println(staff.getStaffName() +" " +loginType + " login in");
		    modelandview.setViewName("staffInterface");
		    httpsession.setAttribute("loginNo", staff.getStaffNo());
		    
		}
		
		else {
			criteria = session.createCriteria(SystemManger.class);
			criteria.add(Restrictions.eq("systemMangerName", loginName));
			
			if(criteria.list().isEmpty()) {
				errorMessage = new String("SystemMangerName not find!");
				modelandview.addObject("errorMessage",errorMessage);
				modelandview.setViewName("loginStaff");
				return modelandview;
			}	
			
			
			criteria.add(Restrictions.eq("password", loginPassword));
			
			if(criteria.list().isEmpty()) {
				errorMessage = new String("Password isn't correct!");
				modelandview.addObject("errorMessage",errorMessage);
				modelandview.setViewName("loginStaff");
				return modelandview;
			}
			
		
			SystemManger system = (SystemManger) criteria.list().get(0);
			System.out.println(system.getSystemMangerName() +" " +loginType + " login in");
			modelandview.setViewName("systemMangerInterface"); 
			httpsession.setAttribute("loginNo", system.getSystemMangerNo());
		}
		
	
		httpsession.setAttribute("loginName", loginName);		
		
		return modelandview;
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
			String errorMessage = new String("UnKnow Error ! /n"
					+ "Please find the SystemManger");
			ModelAndView modelandview = new ModelAndView("loginStaff");
			modelandview.addObject("errorMessage", errorMessage);
			return modelandview;
	    }
	  }
	    
}
