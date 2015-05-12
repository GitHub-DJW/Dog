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
//处理错误		
		
			User user = list.get(0);
			System.out.println(user.getUserName());
		
		session.close();
		
		
		ModelAndView modelandview = new ModelAndView("loginSucceed");
		modelandview.addObject("loginName", loginName);
		modelandview.addObject("loginNo", user.getUserNo());
		return modelandview;
	}
	
	@RequestMapping("/loginStaff.html")
	public ModelAndView loginStaff(){
		ModelAndView modelandview = new ModelAndView("loginStaff");
		
		return modelandview;
	}
	
	@RequestMapping("/loginStaffDeal")
	public ModelAndView loginStaffDeal(HttpServletRequest request,
			HttpServletResponse response, HttpSession httpsession) throws IOException {

		
		
		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");
		String loginType = request.getParameter("loginType");
		System.out.println(loginName + loginPassword+loginType);
		
		ModelAndView modelandview = new ModelAndView();
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		Criteria criteria;
		if(loginType.equals(new String("libraryStaff"))) {
			criteria = session.createCriteria(Staff.class);
			criteria.add(Restrictions.eq("staffName", loginName));
			criteria.add(Restrictions.eq("staffpassword", loginPassword));
			List<Staff> list = criteria.list();
		 //错误处理
			Staff staff = list.get(0);
		    System.out.println(staff.getStaffName());
		    modelandview.setViewName("staffInterface");
		    httpsession.setAttribute("loginNo", staff.getStaffNo());
		    
		}
		
		else {
			criteria = session.createCriteria(SystemManger.class);
			criteria.add(Restrictions.eq("systemMangerName", loginName));
			criteria.add(Restrictions.eq("password", loginPassword));
			List<SystemManger> list = criteria.list();
			//错误处理
			SystemManger system = list.get(0);
			System.out.println(system.getSystemMangerName());
			modelandview.setViewName("SystemMangerInterface"); 
			httpsession.setAttribute("loginNo", system.getSystemMangerNo());
		}
		
		httpsession.setAttribute("loginName", loginName);
		
		return modelandview;
	}
}
