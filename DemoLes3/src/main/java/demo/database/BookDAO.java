package demo.database;
import java.util.List;
import java.util.Properties;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import demo.model.Book;

public class BookDAO {

	private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                //settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                //settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_db?useSSL=false");
                //settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                
                settings.put(Environment.DRIVER, "org.h2.Driver");
                settings.put(Environment.URL, "jdbc:h2:./data/bookStore2");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
                settings.put(Environment.USER, "");
                //settings.put(Environment.PASS, "root");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Book.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

	public void exit() {
		sessionFactory.close();
	}

	public Book create(String bookTitle) {
		// code to save a book
		Book book = new Book();
	    book.setTitle(bookTitle);
	    book.setAuthor("Joshua Bloch");
	    book.setPrice(32.59f);

		Session session = getSessionFactory().openSession();
	    session.beginTransaction();
	 
	    session.save(book);
	 
	    session.getTransaction().commit();
	    session.close();
	    return book;
	}

	public void read(String bookTitle) { 
		
		Session session = getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
        Root<Book> rootBook = criteriaQuery.from(Book.class);
        
        criteriaQuery.where(builder.like(rootBook.get("title"),bookTitle));
        //CriteriaQuery<Book> query = builder.createQuery(Book.class);
        
        Query<Book> q = session.createQuery(criteriaQuery);
        
        List<Book> books=q.getResultList();
        books.forEach(book -> System.out.println(book.getId() + " " + book.getTitle() + " " + book.getPrice()));
        
        session.close();
	}
	
	public Book bookById(long bookId) { 
		
		Session session = getSessionFactory().openSession();
		
        Query<Book> bookQuery = session.createNamedQuery(Book.BOOK_BY_ID, Book.class);
        bookQuery.setParameter("bookId", bookId);
        Book book=bookQuery.getSingleResult(); 
        session.close();
        return book;
	}

	public void update() {
		// code to modify a book
	}

	public void delete() {
		// code to remove a book
	}

}