package demo;
import java.util.Scanner;

import demo.database.BookDAO;
import demo.model.Book;

public class BookStoreApp {

	public static void main(String[] args) {
		System.out.println("Starting ...");


		
		BookDAO manager = new BookDAO();
		//manager.setup();
		System.out.println("Give a book title:");
        
        Scanner scanner = new Scanner(System.in);
        String bookTitle = scanner.nextLine();
	    Book book = manager.create(bookTitle);
	    
        manager.read(bookTitle);
        System.out.println(book.getId());
        System.out.println(manager.bookById(book.getId()));
        
		manager.exit();
	}
}
