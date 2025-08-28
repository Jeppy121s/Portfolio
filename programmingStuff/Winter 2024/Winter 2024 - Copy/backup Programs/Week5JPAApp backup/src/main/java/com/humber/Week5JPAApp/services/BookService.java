package com.humber.Week5JPAApp.services;
import com.humber.Week5JPAApp.models.Book;
import com.humber.Week5JPAApp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public List<Book> getAllBooks(){return bookRepository.findAll(); }

    public int deleteBook(int id){
        if (bookRepository.existsById(id)){
        bookRepository.deleteById(id);
        return 1;
        }
        return 0;
    }

    //get book by id
    public Optional<Book> getBookById(int id){
        //optional returns null if id doesn't exist
        Optional<Book> bookToBeUpdated = bookRepository.findById(id);
        return bookToBeUpdated;
    }

    //update book
    public void updateBook(Book book){
        bookRepository.save(book);
    }
}
