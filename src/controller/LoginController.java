package controller;

import java.util.List;

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
public class LoginController {

	@RequestMapping("/Login.html")
	public ModelAndView login(){
		ModelAndView modelandview = new ModelAndView("Login");
		
		return modelandview;
	}
	
	@RequestMapping("/loginDeal")
	public ModelAndView loginDeal(HttpServletRequest request,
			HttpServletResponse response) {

		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", loginName));
		criteria.add(Restrictions.eq("password", loginPassword));
		
		List<User> list = criteria.list();
		
		for(int i = 0;i < list.size(); i++) {
			User user = list.get(i);
			System.out.println(user.getUserName());
			
		}
		session.close();
		sessionFactory.close();
		
		ModelAndView modelandview = new ModelAndView("");
		
		return modelandview;
	}
}
