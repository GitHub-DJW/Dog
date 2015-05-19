package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HibernateUtil;
import model.Staff;
import model.User;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SystemMangerController {
	
	@RequestMapping("/systemMangerInterface.html")
	public ModelAndView systemMangerInterface() {
		ModelAndView modelandview = new ModelAndView("systemMangerInterface");
		return modelandview;
	}
	
	
	@RequestMapping("/systemMangerPanel.html")
	public ModelAndView systemMangerPanel() {
		ModelAndView modelandview = new ModelAndView("systemMangerPanel");
		return modelandview;
	}
	
	@RequestMapping("/userManger.html")
	public ModelAndView userManger() {
		ModelAndView modelandview = new ModelAndView("userManger");
		return modelandview;
	}
	
	@RequestMapping("/userMangerIndex.html")
	public ModelAndView userMangerIndex() {
		ModelAndView modelandview = new ModelAndView("userMangerIndex");
		return modelandview;
	}
	
	@RequestMapping("/showUser.html")
	public ModelAndView showUser() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(User.class);
		
		List<User> userList = criteria.list();
		
		ModelAndView modelandview = new ModelAndView("showUser");
		modelandview.addObject("userList", userList);
		return modelandview;
	}
	
	@RequestMapping("/deleteUser.html")
	public ModelAndView deleteUser() {
		ModelAndView modelandview = new ModelAndView("deleteUser");
		return modelandview;
	}
	
	
	@RequestMapping("/deleteUserDeal")
	public ModelAndView deleteUserDeal(HttpServletRequest request,
			HttpServletResponse response) {
		try {
		String userName = request.getParameter("userName");
		ModelAndView modelandview = new ModelAndView("deleteUser");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<User> userList = criteria.list();
		
		if(userList.isEmpty()) {
			String errorMessage = new String("User not exsist");
			modelandview.addObject(errorMessage);
			return modelandview;
		}
		
		User user = userList.get(0);
		
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		
		
		String deleteSucceed = new String("Delete Succeed");
		modelandview.addObject("deleteSucceed", deleteSucceed);
		return modelandview;
		}
		catch(Exception e) {
			e.printStackTrace();
			String errorMessage = new String("The user still have some books not return ! can't not delete");
			ModelAndView modelandview = new ModelAndView("deleteUser");
			return modelandview;
		}
	}
	
	
	@RequestMapping("/staffManger.html")
	public ModelAndView staffManger() {
		ModelAndView modelandview = new ModelAndView("staffManger");
		return modelandview;
	}
	
	@RequestMapping("/staffMangerIndex.html")
	public ModelAndView staffMangerIndex() {
		ModelAndView modelandview = new ModelAndView("staffMangerIndex");
		return modelandview;
	}
	
	@RequestMapping("/showStaff.html")
	public ModelAndView showStaff() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Staff.class);
		
		List<Staff> staffList = criteria.list();
		
		ModelAndView modelandview = new ModelAndView("showStaff");
		modelandview.addObject("staffList", staffList);
		return modelandview;
	}
	
	@RequestMapping("/addStaff.html")
	public ModelAndView addStaff() {
		ModelAndView modelandview = new ModelAndView("addStaff");
		return modelandview;
	}
	
	
	@RequestMapping("/addStaffDeal")
	public ModelAndView addStaff(HttpServletRequest request,
			HttpServletResponse response) {
		try {
		String staffName = request.getParameter("staffName");
		String password = new String("000000");
		Staff staff = new Staff();
		staff.setStaffName(staffName);
		staff.setPassword(password); 
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(staff);
		session.getTransaction().commit();
		session.close();
		ModelAndView modelandview = new ModelAndView("addStaff");
		String addSucceed = new String("Add Succeed");
		modelandview.addObject("addSucceed", addSucceed);
		return modelandview;
		}
		catch (Exception e) {
			e.printStackTrace();
			String errorMessage = new String("The user still have some books not return ! can't not delete");
			ModelAndView modelandview = new ModelAndView("addStaff");
			return modelandview;
		}
	}
	
	
	@RequestMapping("/deleteStaff.html")
	public ModelAndView deleteStaff() {
		ModelAndView modelandview = new ModelAndView("deleteStaff");
		return modelandview;
	}
	
	
	@RequestMapping("/deleteStaffDeal")
	public ModelAndView deleteStaffDeal(HttpServletRequest request,
			HttpServletResponse response) {
		try {
		String staffName = request.getParameter("staffName");
		ModelAndView modelandview = new ModelAndView("deleteStaff");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("staffName", staffName));
		List<Staff> staffList = criteria.list();
		
		if(staffList.isEmpty()) {
			String errorMessage = new String("staff not exsist !");
			modelandview.addObject("errorMessage", errorMessage);
			return modelandview;
		}
		
		Staff staff = staffList.get(0);		
		session.beginTransaction();
		session.delete(staff);
		session.getTransaction().commit();
		session.close();
		
		String deleteSucceed = new String("Delete Succeed");
		modelandview.addObject("deleteSucceed", deleteSucceed);
		return modelandview;
		}
		catch(Exception e) {
			e.printStackTrace();
			String errorMessage = new String("Delete Fail!");
			ModelAndView modelandview = new ModelAndView("deleteStaff");
			return modelandview;
		}
	}
	
}
