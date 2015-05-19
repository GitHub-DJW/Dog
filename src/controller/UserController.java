package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.BorrowBook;
import model.HibernateUtil;
import model.Staff;
import model.User;
import model.UserHasBook;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping("/userInterface.html")
	public ModelAndView welcomeWithLogin(HttpServletRequest request,
			HttpServletResponse response) {
		
	    
		ModelAndView modelandview = new ModelAndView("userInterface");
		
		return modelandview;
		
		
	}
	
	
	
	@RequestMapping("/borrowSituation.html")
	public ModelAndView borrowSituation(HttpServletRequest request,
			HttpServletResponse response, HttpSession httpsession){
		
		int loginNo = (int) request.getSession().getAttribute("loginNo");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
			
		String sql = "SELECT BookNo, BookName, Author, Publishers,BorrowDate " + 
		          " FROM Book, User_has_Book "
		          + "WHERE BookNo = Book_BookNo and User_UserNo = " + loginNo + ";";
		
	
	    Query query =	session.createSQLQuery(sql);	    
		List<Object[]> borrowBookList = query.list();		  
		
		
		
		session.close(); 
		
		ModelAndView modelandview = new ModelAndView("borrowSituation");
		modelandview.addObject("borrowBookList", borrowBookList);
		return modelandview;
	}
	
	@RequestMapping("/personalInformation.html") 
	 public ModelAndView personalInformation(HttpServletRequest request,
				HttpServletResponse response, HttpSession session){
		
		System.out.println(session.getAttribute("loginName"));	
		ModelAndView modelandview = new ModelAndView("userInformation");		
		return modelandview;
	}
	
	@RequestMapping("/userPanel.html") 
	 public ModelAndView userPanel(HttpServletRequest request,
				HttpServletResponse response){
	    ModelAndView modelandview = new ModelAndView("userPanel");
		
		return modelandview;
	}
	
	@RequestMapping("/userChangePassword.html")
	public ModelAndView staffChangePassword() {
		
		ModelAndView modelandview = new ModelAndView("userChangePassword");
		
		return modelandview;
				
	}
	
	
	@RequestMapping("/userChangePasswordDeal")
	public ModelAndView userChangePassword(HttpServletRequest request,
			HttpServletResponse response, HttpSession httpsession) {
		try {
		String originalPassword = (String) request.getParameter("originalPassword");
		String newPassword = (String) request.getParameter("newPassword");
		String confirmPassword = (String) request.getParameter("confirmPassword");
		String userName = (String) httpsession.getAttribute("loginName");
		
		ModelAndView modelandview = new ModelAndView("userChangePassword");
		if(!confirmPassword.equals(newPassword)){
			String errorMessage = new String("Two Password isn't equals");
			modelandview.addObject("errorMessage",errorMessage);
			return modelandview;
		}
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		
		Criteria criteria  = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<User> userList = criteria.list();
		User user = userList.get(0);
		
		if(!user.getPassword().equals(originalPassword)){
			String errorMessage = new String("Original Password isn't correct");
			modelandview.addObject("errorMessage",errorMessage);
			return modelandview;
		}
		
		user.setPassword(newPassword);
		session.beginTransaction();
		session.saveOrUpdate(user); 
		session.getTransaction().commit();
		session.close();
		String changeSucceed = new String ("Change Password Succeed !");
		modelandview.addObject("changeSucceed",changeSucceed);
		return modelandview;
		}
		catch(Exception e) {
			e.printStackTrace();
			String errorMessage = new String("Change Password Fail !");
			ModelAndView modelandview = new ModelAndView("userChangePassword");
			modelandview.addObject("errorMessage", errorMessage);
			return modelandview;
		}
	}
	
}
