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

		bookService.saveBook(new Book(5,"Journey To the West","Wu Cheng'en", 35));
		bookService.saveBook(new Book(6,"Tekken","Katsuhiro Harada", 93));
		bookService.saveBook(new Book(7,"Naruto","Kishimoto", 22));
		bookService.saveBook(new Book(8,"Spiderman","Stan Lee", 21));
		bookService.saveBook(new Book(9,"Harry Potter 2","JK Rowling", 22));
		bookService.saveBook(new Book(10,"One Piece Dressrosa","Eichiro Oda", 22));
	}
}
