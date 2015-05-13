package controller;




import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.HibernateUtil;
import model.Staff;
import model.User;
import model.UserHasBook;
import model.UserHasBookId;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	
	@RequestMapping("/borrowPage.html")
	public ModelAndView borrowPage() {
		
		ModelAndView modelandview = new ModelAndView("borrowPage");
		
		return modelandview;
				
	}
	
	@RequestMapping("/ReturnPage.html")
	public ModelAndView ReturnPage() {
		
		ModelAndView modelandview = new ModelAndView("returnPage");
		
		return modelandview;
				
	}
	
	@RequestMapping("/borrowDeal")
	public ModelAndView borrowDeal(HttpServletRequest request,
			HttpServletResponse response) {
		
		String bookNoS = (String) request.getParameter("borrowBookNo");
		String userNoS = (String) request.getParameter("userNo");
		Date borrowDate = new Date();
		
		int bookNo = 0;
		int userNo = 0;
		
		for(int i = 0; i < bookNoS.length(); i++) {
			bookNo = bookNo * 10 + bookNoS.charAt(i) - '0';	
		}
				
		for(int i = 0; i < userNoS.length(); i++) {
			userNo = userNo * 10 + userNoS.charAt(i) - '0';	
		}
		
		UserHasBookId userHasBookId = new UserHasBookId(userNo, bookNo);
		UserHasBook userHasBook = new UserHasBook();
		userHasBook.setId(userHasBookId); 
		userHasBook.setBorrowDate(borrowDate);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    org.hibernate.Session session = sessionFactory.openSession();
	    session.beginTransaction();
		session.save(userHasBook);
	   
		String borrowSucceed = new String("Borrow Book Succeed!");
		session.getTransaction().commit();
		session.close();
		ModelAndView modelandview = new ModelAndView("borrowPage");
		modelandview.addObject("borrowSucceed", borrowSucceed);
		return modelandview;
	}
	
	@RequestMapping("/returnDeal")
	public ModelAndView teturnDeal(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
		String bookNoS = (String) request.getParameter("returnBookNo");
		String userNoS = (String) request.getParameter("userNo");
		
		int bookNo = 0;
		int userNo = 0;
		for(int i = 0; i < bookNoS.length(); i++) {
			bookNo = bookNo * 10 + bookNoS.charAt(i) - '0';	
		}
				
		for(int i = 0; i < userNoS.length(); i++) {
			userNo = userNo * 10 + userNoS.charAt(i) - '0';	
		}
		
		UserHasBookId userHasBookId = new UserHasBookId(userNo, bookNo);
		UserHasBook userHasBook = new UserHasBook();
		userHasBook.setId(userHasBookId); 
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    org.hibernate.Session session = sessionFactory.openSession();
	    session.beginTransaction();
		session.delete(userHasBook);
		session.getTransaction().commit();
		session.close();
		String returnSucceed = new String("Return Book Succeed!");
		ModelAndView modelandview = new ModelAndView("returnPage");
		modelandview.addObject("returnSucceed", returnSucceed);
		return modelandview;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@RequestMapping("/addBookDeal")
	public ModelAndView addBookDeal(HttpServletRequest request,
			HttpServletResponse response) {
		
		String bookName = (String) request.getParameter("bookName");
		String author = (String) request.getParameter("author");
		String publishers = (String) request.getParameter("publishers");
		String retrievalNo = (String) request.getParameter("retrievalNo");
		String bookNumberS = (String) request.getParameter("bookNumber");
		
		
		
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
        String addSucceed = new String("Add Book Succeed!");
		ModelAndView modelandview = new ModelAndView("addBookPage");
		modelandview.addObject("addSucceed", addSucceed);
		return modelandview;
	}
	
	@RequestMapping("/staffChangePassword.html")
	public ModelAndView staffChangePassword() {
		
		ModelAndView modelandview = new ModelAndView("staffChangePassword");
		
		return modelandview;
				
	}
	
	
	@RequestMapping("/staffChangePasswordDea")
	public ModelAndView staffChangePasswordDeal(HttpServletRequest request,
			HttpServletResponse response, HttpSession httpsession) {
		String originalPassword = (String) request.getParameter("originalPassword");
		String newPassword = (String) request.getParameter("newPassword");
		String confirmPassword = (String) request.getParameter("confirmPassword");
		String staffName = (String) httpsession.getAttribute("loginName");
		
		ModelAndView modelandview = new ModelAndView("staffChangePassword");
		if(!confirmPassword.equals(newPassword)){
			String errorMessage = new String("Two Password isn't equals");
			modelandview.addObject(errorMessage);
			return modelandview;
		}
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();
		
		Criteria criteria  = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("staffName", staffName));
		List<Staff> staffList = criteria.list();
		Staff staff = staffList.get(0);
		
		if(!staff.getStaffpassword().equals(originalPassword)){
			String errorMessage = new String("Original Password isn't correct");
			modelandview.addObject(errorMessage);
			return modelandview;
		}
		
		staff.setStaffpassword(newPassword);
		session.beginTransaction();
		session.saveOrUpdate(staff); 
		session.getTransaction().commit();
		session.close();
		String changeSucceed = new String ("ChangeSucceed");
		modelandview.addObject(changeSucceed);
		return modelandview;
	}
	
}
