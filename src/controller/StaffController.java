package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaffController {
	
	@RequestMapping("/staffPanel.html")
	public ModelAndView staffPanel() {
		
		ModelAndView modelandview = new ModelAndView("staffPanel");
		
		return modelandview;
				
	}
	
	@RequestMapping("/addBookPage.html")
	public ModelAndView addBook() {
		
		ModelAndView modelandview = new ModelAndView("addBookPage");
		
		return modelandview;
				
	}
	
	
	@RequestMapping("/addBookDeal")
	public ModelAndView addBookDeal(HttpServletRequest request,
			HttpServletResponse response) {
		
		String bookName = (String) request.getAttribute("bookName");
		String author = (String) request.getAttribute("author");
		String publishers = (String) request.getAttribute("publishers");
		String retrievalNo = (String) request.getAttribute("retrievalNo");
		String bookNumberS = (String) request.getAttribute("bookNumber");
		
		
		
		int bookNumber = 0;
		
		for(int i = 0; i < bookNumberS.length(); i++) {
			bookNumber = bookNumber * 10 + bookNumberS.charAt(i) - '0';	
		}
		
        int remainingBookNumber = bookNumber;
		
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        org.hibernate.Session session = sessionFactory.openSession();
        
        Book book = new Book();
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setPublishers(publishers);
        book.setRetrievalNo(retrievalNo);
        book.setBookNumber(bookNumber);
        book.setRemainingBookNumber(remainingBookNumber); 
        session.save(book);
        session.close();
        
		ModelAndView modelandview = new ModelAndView("addBookPage");
		
		return modelandview;
	}
	
	
	
	
}
