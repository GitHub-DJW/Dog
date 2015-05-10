package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.HibernateUtil;
import model.User;
import model.UserHasBook;

import org.hibernate.Criteria;
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
	
	@RequestMapping("/userIndex.html")
	public ModelAndView indexUser(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView("userIndex");
		
		return modelandview;
		
		
	}
	
	@RequestMapping("/borrowSituation.html")
	public ModelAndView borrowSituation(HttpServletRequest request,
			HttpServletResponse response){
        
		String loginName = (String) request.getSession().getAttribute("loginName");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
	//	Criteria  userHasBook = session.createCriteria(UserHasBook.class);
	//	userHasBook.add(Restrictions.eq("userNo", loginNo));
	//	List<UserHasBook> userHasBookList = userHasBook.list();
		
	//	
		
		
	//	for(int i = 0; i < userHasBookList.size(); i++) {
	//	session.createQuery("SELECT BookNo, BookName, FROM Book, "
	//			+ "  User_has_Book "
	//			+ "WHERE BookNo = Book_BookNo and User_UserNo = 1");
		
		 
//		}
				
		Criteria bookcriteria = session.createCriteria(Book.class)
				.createCriteria("userHasBooks").add(Restrictions.eq("userNo", 1));		
		List<Book> bookList = bookcriteria.list();
		
		session.close(); 
		
		ModelAndView modelandview = new ModelAndView("borrowSituation");
		modelandview.addObject("borrowBookList", bookList);
		return modelandview;
	}
	
	@RequestMapping("/personalInformation.html") 
	 public ModelAndView personalInformation(HttpServletRequest request,
				HttpServletResponse response){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		
		
		
		session.close();
		
		ModelAndView modelandview = new ModelAndView("UserInformation");
		
		return modelandview;
	}
	
	@RequestMapping("/userPanel.html") 
	 public ModelAndView userPanel(HttpServletRequest request,
				HttpServletResponse response){
		
		
		ModelAndView modelandview = new ModelAndView("userPanel");
		
		return modelandview;
	}
	
}
