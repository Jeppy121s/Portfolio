package com.humber.Week8SpringSecurityApp.controllers;

import com.humber.Week8SpringSecurityApp.models.MyUser;
import com.humber.Week8SpringSecurityApp.services.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController implements ErrorController {

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/error")
    public String error403(){
        return "/auth/error403";
    }

    @GetMapping("/login")
    public String login(Model model,@RequestParam(required = false) String msg){

        model.addAttribute("msg",msg);
        return "/auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
        //perform logout logic
        new SecurityContextLogoutHandler().logout(request,response,authentication);
//        return "home";
        return "redirect:/login?msg=You have been logged out";
    }

    @GetMapping("/register")
    public String register(Model model, @RequestParam(required = false) String msg){

        model.addAttribute("msg", msg);
        model.addAttribute("user",new MyUser());

        return "/auth/register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute MyUser user){
        // save user to database
        int saveUserCode= userService.saveUser(user);

        if(saveUserCode==0)
        {return "redirect:/register?msg=User already exists!";}
        else {
            return "redirect:/login?msg=User has been registered!";
        }
        //redirect to login page

    }


}
