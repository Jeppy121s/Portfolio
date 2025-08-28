package com.humber.cpan.Week1SpringProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tom")
public class HomeWCController {
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	@GetMapping("/about")
	public String getAbout() {
		return "about";
	}
	

}
