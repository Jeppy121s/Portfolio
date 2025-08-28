package com.humber.TekkenAppCPAN.controllers;
import com.humber.TekkenAppCPAN.models.Dish;
import com.humber.TekkenAppCPAN.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// Karamjit Judge N01477742 Lab 1+2

@Controller
public class HomeController {

    @Autowired
    DishService dishService=new DishService();


    @Value("${restaurant.name}")
    public String name;
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("restaurantName", name);
        return "home";
    }
    @GetMapping("/menu")
    public String menu(Model model){
        model.addAttribute("dishes",dishService.getDishes());
        return"menu";
    }
    @GetMapping("/add-dish")
    public String addDish(Model model){
        model.addAttribute("item", new Dish());
        return"add-dish";
    }
    @PostMapping("/add-dish")
    public String addDish(Model model, @ModelAttribute Dish dish){
        model.addAttribute("dishes", dish);
        model.addAttribute("success", "dish added successfully");
        return "menu";
    }


}
