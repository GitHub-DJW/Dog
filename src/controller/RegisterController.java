package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HibernateUtil;
import model.User;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegisterController {

	@RequestMapping("/register.html")
	public ModelAndView register() {

		ModelAndView modelandview = new ModelAndView("register");
		
		return modelandview;
	}
	
	
	@RequestMapping("/registerDeal")
	public ModelAndView registerDeal(HttpServletRequest request,
			HttpServletResponse response) {
	    try {
	    request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		
		ModelAndView modelandview = new ModelAndView("register");
		String errorMessage ;
		
		if(password.length() > 6 ) {
			
		}
	
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		
		
		criteria.add(Restrictions.eq("userName", userName));
		
		if(!criteria.list().isEmpty()) {
			errorMessage = new String("User Name exsist! Please change other User Name.");
			modelandview.addObject("errorMessage", errorMessage);
			return modelandview;
		}
		
		if(password.equals(new String(""))) {
			errorMessage = new String("Password can't be empty");
			modelandview.addObject("errorMessage", errorMessage);
			return modelandview;
		}
		
		if(password.length() > 6) {
			errorMessage = new String("Password length can't pass 6 ");
			modelandview.addObject("errorMessage", errorMessage);
			return modelandview;
		}
		
		if(!password.equals(confirmPassword)) {
			errorMessage = new String("Two Passwords isn't equals !");
			modelandview.addObject("errorMessage", errorMessage);
			return modelandview;
		}
		
		
		session.beginTransaction();	
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		System.out.println(userName + password);	
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
				
		modelandview.setViewName("registerSucceed");
		return modelandview;
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
			String errorMessage = new String("UnKnow Error ! /n"
					+ "Please find the SystemManger");
			ModelAndView modelandview = new ModelAndView("register");
			modelandview.addObject("errorMessage", errorMessage);
			return modelandview;
	    }
	}
	

}
