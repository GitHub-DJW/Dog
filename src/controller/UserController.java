package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.HibernateUtil;

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
        
		System.out.println(httpsession.getId());
		
		
		
		int loginNo = (int) request.getSession().getAttribute("loginNo");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();

		String sql = "SELECT BookNo, BookName, Author, Publishers, RetrievalNo,BookNumber, RemainingBookNumber " + 
		          " FROM Book, User_has_Book "
		          + "WHERE BookNo = Book_BookNo and User_UserNo = " + loginNo + ";";
		
	
	    Query query =	session.createSQLQuery(sql).addEntity(Book.class); 
		

		List<Book> bookList = query.list();		
		
		session.close(); 
		
		ModelAndView modelandview = new ModelAndView("borrowSituation");
		modelandview.addObject("borrowBookList", bookList);
		return modelandview;
	}
	
	@RequestMapping("/personalInformation.html") 
	 public ModelAndView personalInformation(HttpServletRequest request,
				HttpServletResponse response, HttpSession session){
		
		System.out.println(session.getId());
		
		System.out.println(session.getAttribute("loginName"));
		
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
