package com.humber.Week8SpringSecurityApp.controllers;

import com.humber.Week8SpringSecurityApp.models.Book;
import com.humber.Week8SpringSecurityApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/library/admin")
public class AdminController {

    private final BookService bookService;

    @Autowired
    public AdminController(BookService bookService){
        this.bookService=bookService;
    }


    @GetMapping("/add-book")
    public String addBook(Model model){
        model.addAttribute("item", new Book());
        return "add-book";
    }
    @PostMapping("/post-book")
    public String postBook(@ModelAttribute Book book, Model model){

        int saveCode= bookService.saveBook(book);

        model.addAttribute("books",bookService.getAllBooks());
        if(saveCode==0){
            model.addAttribute("msg","Book too expensive. failed to add!");
            return "catalogue";
        }
        model.addAttribute("msg","successfully added book");
        return "catalogue";
    }


    //Path variable takes path from mapping
    @GetMapping("/delete/{id}")
    public String removeBook(@PathVariable int id){//, Model model){

        int deleteStatusCode=bookService.deleteBook(id);

        if (deleteStatusCode==1) {
            //model.addAttribute("books",bookService.getAllBooks());
            //model.addAttribute("msg","book deleted successfully");
            return "redirect:/library/catalogue/1?msg=Book Deleted successfully";

        }
        //model.addAttribute("books",bookService.getAllBooks());
        //model.addAttribute("msg", "book doesn't exist. Delete failed");
        return "redirect:/library/catalogue/1?msg=Failed to delete. Book doesn't exist";
    }

    @GetMapping("/update/{id}")
    public String updateBook(@PathVariable int id, Model model){
        Optional<Book> bookToBeUpdated=bookService.getBookById(id);
        model.addAttribute("item",bookToBeUpdated.orElse(null));
        return "add-book";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book book) {
        //update book
        bookService.updateBook(book);
        return "redirect:/library/catalogue/1?msg=Book Updated Successfully";
    }

}
