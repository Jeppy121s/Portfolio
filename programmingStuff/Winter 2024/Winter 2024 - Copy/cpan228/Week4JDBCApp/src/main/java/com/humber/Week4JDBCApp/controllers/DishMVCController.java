package com.humber.Week4JDBCApp.controllers;

import com.humber.Week4JDBCApp.models.Book;
import com.humber.Week4JDBCApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class DishMVCController {
    @Autowired
    private BookService bookService;
    //getting values from app properties and storing it to variable name
    @Value("${library.name}")
    private String name;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("libraryName",name);
        return "home";
    }

    @GetMapping("/catalogue")
    public String catalogue(Model model){
        model.addAttribute("books",bookService.getAllBooks());
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


}
