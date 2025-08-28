package com.humber.Week4JDBCApp.services;
import com.humber.Week4JDBCApp.models.Book;
import com.humber.Week4JDBCApp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public int saveBook(Book book){
    if(book.getPrice()<=100){
        bookRepository.save(book);
        return 1;
    }
        return 0;
    }
    public List<Book> getAllBooks(){


    return bookRepository.findAll();
    }
}
