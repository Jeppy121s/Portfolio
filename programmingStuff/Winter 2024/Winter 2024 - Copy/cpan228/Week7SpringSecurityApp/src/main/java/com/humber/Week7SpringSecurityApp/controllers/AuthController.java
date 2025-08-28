package com.humber.Week7SpringSecurityApp.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController implements ErrorController {
    @GetMapping("/error")
    public String error403(){
        return "/auth/error403";
    }

    @GetMapping("/login")
    public String login(){
        return "/auth/login";
    }


}
