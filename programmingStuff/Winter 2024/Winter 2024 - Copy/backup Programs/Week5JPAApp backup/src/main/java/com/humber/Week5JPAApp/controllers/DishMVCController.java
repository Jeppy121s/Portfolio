package com.humber.Week5JPAApp.controllers;

import com.humber.Week5JPAApp.models.Book;
import com.humber.Week5JPAApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/library")
public class DishMVCController {
    private final BookService bookService;

    @Autowired
    public DishMVCController(BookService bookService){
        this.bookService=bookService;
    }



    //getting values from app properties and storing it to variable name
    @Value("${library.name}")
    private String name;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("libraryName",name);
        return "home";
    }

    @GetMapping("/catalogue")
    public String catalogue(Model model, @RequestParam(required = false) String msg){
        model.addAttribute("books",bookService.getAllBooks());
        model.addAttribute("msg",msg);
        return "catalogue";
    }
    @GetMapping("/add-book")
    public String addBook(Model model){
        model.addAttribute("item", new Book());
        return "add-book";
    }
    @PostMapping("/post-book")
    public String postBook(@ModelAttribute Book book,Model model){

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
            return "redirect:/library/catalogue?msg=Book Deleted successfully";

        }
        //model.addAttribute("books",bookService.getAllBooks());
        //model.addAttribute("msg", "book doesn't exist. Delete failed");
        return "redirect:/library/catalogue?msg=Failed to delete. Book doesn't exist";
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
        return "redirect:/library/catalogue?msg=Book Updated Successfully";
    }
}
