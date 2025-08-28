package com.humber.Week7SpringSecurityApp.controllers;

import com.humber.Week7SpringSecurityApp.models.Book;
import com.humber.Week7SpringSecurityApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
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

    @Value("${page.size}")
    private int pageSize;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("libraryName",name);
        return "home";
    }



    @GetMapping("/catalogue/{pageNo}")
    public String catalogue(Model model,
                            @RequestParam(required = false) String msg,
                            @RequestParam(required = false) String searchedCategory,
                            @RequestParam(required = false) Double searchedPrice,
                            @PathVariable int pageNo,
                            @RequestParam(required=false) String sortField,
                            @RequestParam(required = false) String sortDirection
    ){
        //search
        if(searchedCategory != null && searchedPrice != null){
           model.addAttribute( "books", bookService.getFilteredBooks(searchedCategory,searchedPrice));
           model.addAttribute("msg","books filtered successfully");
           return "catalogue";
        }

        if(sortField==null)sortField="id";
        if(sortDirection==null)sortDirection="asc";
        //get pages
        Page<Book> page=bookService.getPaginatedBooks(pageNo,pageSize,sortField,sortDirection);
        //get content from pages
        model.addAttribute("books",page.getContent());

        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalElements",page.getTotalElements());

        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDirection",sortDirection);
        model.addAttribute("reversedSortDir",sortDirection.equals("asc")?"desc":"asc");


        model.addAttribute("msg",msg);
        return "catalogue";
    }

//
//
//    @GetMapping("/add-book")
//    public String addBook(Model model){
//        model.addAttribute("item", new Book());
//        return "add-book";
//    }
//    @PostMapping("/post-book")
//    public String postBook(@ModelAttribute Book book,Model model){
//
//        int saveCode= bookService.saveBook(book);
//
//        model.addAttribute("books",bookService.getAllBooks());
//        if(saveCode==0){
//            model.addAttribute("msg","Book too expensive. failed to add!");
//            return "catalogue";
//        }
//        model.addAttribute("msg","successfully added book");
//        return "catalogue";
//    }
//
//
//    //Path variable takes path from mapping
//    @GetMapping("/delete/{id}")
//        public String removeBook(@PathVariable int id){//, Model model){
//
//        int deleteStatusCode=bookService.deleteBook(id);
//
//        if (deleteStatusCode==1) {
//            //model.addAttribute("books",bookService.getAllBooks());
//            //model.addAttribute("msg","book deleted successfully");
//            return "redirect:/library/catalogue/1?msg=Book Deleted successfully";
//
//        }
//        //model.addAttribute("books",bookService.getAllBooks());
//        //model.addAttribute("msg", "book doesn't exist. Delete failed");
//        return "redirect:/library/catalogue/1?msg=Failed to delete. Book doesn't exist";
//    }
//
//    @GetMapping("/update/{id}")
//    public String updateBook(@PathVariable int id, Model model){
//        Optional<Book> bookToBeUpdated=bookService.getBookById(id);
//        model.addAttribute("item",bookToBeUpdated.orElse(null));
//        return "add-book";
//    }
//
//    @PostMapping("/update")
//    public String updateBook(@ModelAttribute Book book) {
//        //update book
//        bookService.updateBook(book);
//        return "redirect:/library/catalogue/1?msg=Book Updated Successfully";
//    }
}
