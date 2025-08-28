package com.humber.Week5JPAApp;
import com.humber.Week5JPAApp.models.Book;
import com.humber.Week5JPAApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week5JPAAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Week5JPAAppApplication.class, args);
	}

	private BookService bookService;

	@Autowired
	Week5JPAAppApplication(BookService bookService){
		this.bookService=bookService;
	}

	@Override
	public void run(String... args) throws Exception {

		bookService.saveBook(new Book(5,"Jordans","Nike", 20));
		bookService.saveBook(new Book(6,"Hoodie","Puma", 21));
		bookService.saveBook(new Book(7,"Shorts","Nike", 20));
		bookService.saveBook(new Book(8,"Boots","Hot Topic", 22));
		bookService.saveBook(new Book(9,"T-shirt","Hot Topic", 22));
		bookService.saveBook(new Book(10,"Hoodie","Nike", 20));
	}
}
