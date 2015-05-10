package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HibernateUtil;
import model.User;

import org.hibernate.SessionFactory;
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
		//！！！！添加用户名重复检测
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		System.out.println(username + password);
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		session.beginTransaction();
	
		// this would save the Student_Info object into the database
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		
		
		ModelAndView modelandview = new ModelAndView("registerSucceed");
		
		return modelandview;
	}
	

}
