package com.example.SpringRestApp.controllers;

import com.example.SpringRestApp.models.Dish;
import com.example.SpringRestApp.services.CategoryService;
import com.example.SpringRestApp.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant/api/v1")
public class DishController {
    private final DishService dishService;
    private final CategoryService categoryService;
    @Autowired
    public DishController(DishService dishService, CategoryService categoryService){
        this.dishService=dishService;
        this.categoryService=categoryService;
    }


    //get all dishes rest api
    @GetMapping("/dishes")
    public ResponseEntity<List<Dish>> getAllDishes(){
        return ResponseEntity.ok(dishService.getAllDishes());
    }

    //get 1 dish by id
    @GetMapping("/dishes/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable Integer id){
        return ResponseEntity.ok(dishService.getDishById(id));
    }

    //add dish
    @PostMapping("/addDish")
    public ResponseEntity<String> addNewDish(@RequestBody Dish dish){
        Category existingCategory=categoryService.getCategoryByName(dish.getCategory().getName());

        if(existingCategory!=null){
            dish.setCategory(existingCategory);
        }
        try {
            dishService.addDish(dish);

        }catch(IllegalStateException e){
            return ResponseEntity.badRequest().body("Error "+e.getMessage());
        }
        return ResponseEntity.ok("Dish added Successfuly!");
    }
    //delete dish
    @DeleteMapping("/deleteDish/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable Integer id, @RequestBody Dish dish){
        try {
            dishService.deleteDish(id, dish);
        }catch(IllegalStateException e){
            return ResponseEntity.badRequest().body("Error "+e.getMessage());
        }
        return ResponseEntity.ok("Dish added Successfuly!");
    }
    @PutMapping("/updateDish/{id}")
    public ResponseEntity<String> updateDish(@PathVariable Integer id, @RequestBody Dish dish){
        try {
            dishService.updateDish(id, dish);
        }catch(IllegalStateException e){
            return ResponseEntity.badRequest().body("Error "+e.getMessage());
        }
        return ResponseEntity.ok("Dish added Successfuly!");
    }

}
