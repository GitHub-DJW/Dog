package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	
	@RequestMapping("/")
	public ModelAndView welcomeWithOutLogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView("welcome");
		
		return modelandview;
	}
	
	@RequestMapping("/searchPage.html")
	public ModelAndView searchPage(HttpServletRequest request,
			HttpServletResponse response,HttpSession httpsession) {
		
		
		ModelAndView modelandview = new ModelAndView("searchPage");
		
		return modelandview;
		
		
	}
	
	@RequestMapping("/searchResult.html")
	public ModelAndView searchResult(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		String bookName = request.getParameter("bookName");
				
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		criteria.add(Restrictions.like("bookName", "%" + bookName + "%"));
		List<Book> bookList = criteria.list();				
		session.close();
		
		ModelAndView modelandview = new ModelAndView("searchResult");
		modelandview.addObject("bookList", bookList);
		return modelandview;
		
		
	}
	
	@RequestMapping("/loginPanel")
	public ModelAndView loginPane() {
		ModelAndView modelandview = new ModelAndView("loginPanel");
		
		return modelandview;
	}
	
	@RequestMapping("/exit.html")
	public ModelAndView exit(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		
		session.invalidate();
		
        ModelAndView modelandview = new ModelAndView("welcome");
		
		return modelandview;
	}
}
