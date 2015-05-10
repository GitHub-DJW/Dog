package controller;

import java.io.IOException;
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

	@RequestMapping("/login.html")
	public ModelAndView login(){
		ModelAndView modelandview = new ModelAndView("login");
		
		return modelandview;
	}
	
	@RequestMapping("/loginDeal")
	public ModelAndView loginDeal(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");
		
		System.out.println(loginName + loginPassword);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", loginName));
		criteria.add(Restrictions.eq("password", loginPassword));
		
		List<User> list = criteria.list();
/*处理错误		
		if(list.size() == 0) {
			response.sendError(1, "UserName or Password rong!");
		}
*/			
			User user = list.get(0);
			System.out.println(user.getUserName());
			
		
		session.close();
		
		
		ModelAndView modelandview = new ModelAndView("loginSucceed");
		modelandview.addObject("loginName", loginName);
		modelandview.addObject("loginNo", user.getUserNo());
		return modelandview;
	}
}
