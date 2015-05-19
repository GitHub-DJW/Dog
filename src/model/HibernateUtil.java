package model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil<E> {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;


	
	private static SessionFactory buildSessionFactory() {

		try {
			Configuration configuration = new Configuration();
			configuration.configure();

			serviceRegistry = new ServiceRegistryBuilder().applySettings(
			
					configuration.getProperties()).buildServiceRegistry();

			
			return configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {

			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}
	
	
/*	二次重构再弄
	public static boolean canRegisterNameUse(String name) {
		
		
		return false;
	}
	
	public static User findUser(String name, String password) {
		try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    org.hibernate.Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class); 
		criteria.add(Restrictions.eq("userName", name));
		criteria.add(Restrictions.eq("password", password));
		
		List<User> list = criteria.list();		
			User user = list.get(0);
				
		session.close();    
		return user; 
		}
		catch(Exception e) {
		e.printStackTrace();
		return null;	
		}
		 
	}	
	
	public List<Book> findBooks(String bookName) {
		return null;
	}
	
	public List<Book> borrowCondition(int userNo ) {
		return null;
	}
	
	public boolean saveNewPassword(String newPassword) {
		return false;
	}
	
	public List<E> showEntityList() {
		return null;
	}
	
	public boolean addEntity(E e) {
		return false;
	}
	
	public boolean borrowBook(int userNo, int bookNo) {
		return false;
	}
	public boolean returnBook(int userNo, int bookNo) {
		return false;
	}
	
	boolean setPasswordDefault(E e, int no){
		
		return false;
	}
	*/
}

